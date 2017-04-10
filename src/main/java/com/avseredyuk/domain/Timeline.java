package com.avseredyuk.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton_Serediuk on 4/10/2017.
 */
public class Timeline {
    private User user;
    private List<Tweet> tweets;

    public Timeline(List<Tweet> tweets, User user) {
        this.tweets = new ArrayList<>(tweets);
        this.user = user;
    }

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    public Iterable<Tweet> getTweets() {
        return new ArrayList<>(tweets);
    }

    public User getUser() {
        return user;
    }
}
