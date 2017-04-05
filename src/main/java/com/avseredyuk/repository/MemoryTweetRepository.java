package com.avseredyuk.repository;

import com.avseredyuk.domain.Tweet;
import com.avseredyuk.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public class MemoryTweetRepository implements TweetRepository {
    private final List<Tweet> tweets = new ArrayList<>();

    @PostConstructBean
    public void initialize() {
        tweets.add(new Tweet(new User("vasya"), "tweet1"));
        tweets.add(new Tweet(new User("petya"), "tweet2"));
    }

    @PostConstructBean
    public void initstuff2() {
        tweets.add(new Tweet(new User("kolya"), "tweet3"));
        tweets.add(new Tweet(new User("ivan"), "tweet4"));
    }

    @Benchmark
    public void save(Tweet tweet) {

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {}

        tweets.add(tweet);
    }

    @Benchmark(active = false)
    public Iterable<Tweet> findAll() {

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {}

        return new ArrayList<>(tweets);
    }

}
