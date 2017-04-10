package com.avseredyuk.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
@Component
@Scope("prototype")
public class Tweet {
    public static final int TWEET_MAX_TEXT_LENGTH = 140;
    private User user;
    private String text;
    //todo
    private List<User> retweets;
    private boolean isRetweet;
    //todo
    private List<User> likes;

    public Tweet() {
    }

    public Tweet(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
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
