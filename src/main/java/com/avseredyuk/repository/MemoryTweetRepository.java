package com.avseredyuk.repository;

import com.avseredyuk.domain.Tweet;
import com.avseredyuk.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
@Repository("tweetRepository")
public class MemoryTweetRepository implements TweetRepository {
    private final List<Tweet> tweets = new ArrayList<>();

    @Override
    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    @Override
    public Iterable<Tweet> findAll() {
        return new ArrayList<>(tweets);
    }

}
