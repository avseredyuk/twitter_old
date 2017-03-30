package com.avseredyuk.repository;

import com.avseredyuk.domain.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public class MemoryTweetRepository implements TweetRepository {
    private final List<Tweet> tweets = new ArrayList<Tweet>();

    public void save(Tweet tweet) {
        tweets.add(tweet);
    }

    public Iterable<Tweet> findAll() {
        return new ArrayList<Tweet>(tweets);
    }
}
