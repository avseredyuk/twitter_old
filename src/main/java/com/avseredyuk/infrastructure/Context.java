package com.avseredyuk.infrastructure;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public interface Context {
    <T> T getBean(String beanName) throws Exception;
}
