package com.avseredyuk.infrastructure;

import com.avseredyuk.repository.PostConstructBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public class ApplicationContext implements Context {
    private final Config config;
    private final Map<String, Object> beans = new HashMap<>();

    public ApplicationContext(Config config) {
        this.config = config;
    }

    @Override
    public <T> T getBean(String beanName) throws Exception {
        T bean = (T) beans.get(beanName);
        if (bean != null) {
            return bean;
        }
        bean = instantiate(beanName);

        callInitMethod(bean);
        callPostConstructBean(bean);

        bean = createProxy(bean);

        beans.put(beanName, bean);
        return bean;
    }

    private <T> T instantiate(String beanName) throws Exception{
        Class<?> clazz = config.getImpl(beanName);
        if (clazz == null) {
            throw new RuntimeException("Bean not found");
        }

        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();

        }

        T bean = (T) clazz.newInstance();
        return bean;
    }

    private <T> T createProxy(T bean) {
        T newBean = (T) Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                new BenchmarkInvocationHandler(bean));
        return newBean;
    }

    private void callPostConstructBean(Object bean) throws Exception {
        Class<?> clazz = bean.getClass();
        for (Method method : clazz.getMethods()) {
            if (method.isAnnotationPresent(PostConstructBean.class)) {
                method.invoke(bean);
            }
        }
    }

    private void callInitMethod(Object bean) throws Exception {
        Class<?> clazz = bean.getClass();
        Method method;
        try {
            method = clazz.getMethod("init");
        } catch (NoSuchMethodException e) {
            return;
        }
        method.invoke(bean);
    }
}
