package com.avseredyuk.infrastructure;

import com.avseredyuk.repository.PostConstructBean;
import com.avseredyuk.util.StringUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

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

        BeanBuilder builder = new BeanBuilder(config.getImpl(beanName), beanName);
        builder.createBean();
        builder.callPostCreateMethod();
        builder.callInitMethod();
        builder.createBeanProxy();
        bean = (T) builder.build();

        beans.put(beanName, bean);
        return bean;
    }

    public class BeanBuilder {
        private Class<?> clazz;
        private String beanName;
        private Object bean;

        public BeanBuilder(Class<?> clazz, String beanName) {
            this.clazz = clazz;
            this.beanName = beanName;
        }

        public void createBean() throws Exception {
            if (clazz == null) {
                throw new RuntimeException("Bean not found");
            }
            Collection<Class<?>> classesInConfig = config.getList();
            Constructor[] constructors = clazz.getConstructors();

            for (Constructor constructor : constructors) {
                Class<?>[] paramClasses = constructor.getParameterTypes();
                Object[] params = new Object[paramClasses.length];
                int i = 0;
                for (Class<?> paramClass : paramClasses) {
                    String paramClassName = StringUtil.firstLetterToLower(paramClass.getSimpleName());

                    for (Class<?> cfgClass : classesInConfig) {
                        if (paramClass.isAssignableFrom(cfgClass)) {
                            params[i] = getBean(paramClassName);
                            i++;
                        }
                    }
                }
                if (i < params.length) {
                    continue;
                }
                if (params.length > 0) {
                    params = Stream.of(params)
                            .map(o -> Proxy.isProxyClass(o.getClass())
                                    ? ((BenchmarkInvocationHandler) Proxy.getInvocationHandler(o)).getOriginalObject()
                                    : o)
                            .toArray();
                    bean = constructor.newInstance(params);
                    return;
                } else {
                    break;
                }
            }
            bean = clazz.newInstance();
        }

        public void callPostCreateMethod() throws Exception {
            for (Method method : clazz.getMethods()) {
                if (method.isAnnotationPresent(PostConstructBean.class)) {
                    method.invoke(bean);
                }
            }
        }

        public void callInitMethod() throws Exception {
            Method method;
            try {
                method = clazz.getMethod("init");
            } catch (NoSuchMethodException e) {
                return;
            }
            method.invoke(bean);
        }

        public void createBeanProxy() {
            Method[] methods = bean.getClass().getMethods();
            for (Method method : methods) {
                if (method.getAnnotations().length > 0) {
                    bean = Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                            bean.getClass().getInterfaces(),
                            new BenchmarkInvocationHandler(bean));
                    break;
                }
            }
        }

        public Object build() throws Exception {
            return bean;
        }
    }
}
