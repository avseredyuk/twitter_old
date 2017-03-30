package com.avseredyuk.repository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 * //todo test this annotation in service or so
 * // не на том обьекте будет пытаться вызваться
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Benchmark {
}
