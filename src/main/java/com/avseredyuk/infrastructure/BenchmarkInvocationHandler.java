package com.avseredyuk.infrastructure;

import com.avseredyuk.repository.Benchmark;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public class BenchmarkInvocationHandler implements InvocationHandler {
    private Object originalObject;

    public BenchmarkInvocationHandler(Object originalObject) {
        this.originalObject = originalObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Class[] paramTypes = method.getParameterTypes();
        Method originalMethod = originalObject.getClass().getMethod(methodName, paramTypes);

        if (originalMethod.isAnnotationPresent(Benchmark.class)) {
            Benchmark benchmark = originalMethod.getAnnotation(Benchmark.class);
            if (benchmark.active()) {
                long startTime = System.currentTimeMillis();
                Object object = method.invoke(originalObject, args);
                long endTime = System.currentTimeMillis();
                System.out.println(String.format("Benchmark of method %s.%s%s: %d",
                        originalObject.getClass().getName(),
                        methodName,
                        Stream.of(paramTypes)
                                .map(Class::getName)
                                .collect(Collectors.joining(", ", "(", ")")),
                        endTime - startTime));
                return object;
            }
        }
        return method.invoke(originalObject, args);
    }
}
