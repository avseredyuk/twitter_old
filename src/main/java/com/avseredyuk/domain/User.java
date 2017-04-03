package com.avseredyuk.domain;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public class User {
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
