package com.avseredyuk.infrastructure;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public class InitialContext {
    private final Config config;

    public InitialContext(Config config) {
        this.config = config;
    }

    public Object lookup(String name) throws IllegalAccessException, InstantiationException {
        return config.getImpl(name).newInstance();
    }
}
