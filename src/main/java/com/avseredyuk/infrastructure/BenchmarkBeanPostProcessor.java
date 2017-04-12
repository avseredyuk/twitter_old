package com.avseredyuk.infrastructure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Anton_Serediuk on 4/5/2017.
 */
public class BenchmarkBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("CLASS: " + o.getClass().getCanonicalName());
        Method[] methods = o.getClass().getMethods();
        for (Method method : methods) {
            System.out.println("  METHOD: " + method.getName() + "(" +
                    method.isAnnotationPresent(Benchmark.class) + ")");
            if (method.isAnnotationPresent(Benchmark.class)) {
                System.out.println("     PROXIFIED");
                o = Proxy.newProxyInstance(o.getClass().getClassLoader(),
                        o.getClass().getInterfaces(),
                        new BenchmarkInvocationHandler(o));
                break;
            }
        }
        return o;
    }
}
