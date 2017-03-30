package com.avseredyuk.repository;

import com.avseredyuk.domain.Tweet;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public interface TweetRepository {
    void save(Tweet tweet);
    Iterable<Tweet> findAll();
}
