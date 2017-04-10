package com.avseredyuk.domain;

import java.util.List;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public class User {
    private Integer id;
    private String name;
    //todo
    private List<Tweet> ownRetweets;

    public User(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
