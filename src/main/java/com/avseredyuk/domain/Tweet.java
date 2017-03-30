package com.avseredyuk.domain;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public class Tweet {
    private User user;
    private String text;

    public Tweet(User user, String text) {
        this.user = user;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "user=" + user +
                ", text='" + text + '\'' +
                '}';
    }
}
