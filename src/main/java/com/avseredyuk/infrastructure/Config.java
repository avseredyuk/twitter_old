package com.avseredyuk.infrastructure;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public interface Config {
    Class<?> getImpl(String name);
}
