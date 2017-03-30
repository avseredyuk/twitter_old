package com.avseredyuk.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public class Timeline {
    private final List<Tweet> tweets = new ArrayList<Tweet>();

    public void put(Tweet tweet) {
        tweets.add(tweet);
    }

    public Iterable<Tweet> tweets() {
        return new ArrayList<Tweet>(tweets);
    }
}
