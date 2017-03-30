package com.avseredyuk.domain;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
