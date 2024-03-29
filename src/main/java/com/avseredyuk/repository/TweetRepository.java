package com.avseredyuk.repository;

import com.avseredyuk.domain.Tweet;
import com.avseredyuk.domain.User;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public interface TweetRepository {
    void add(Tweet tweet);
    Iterable<Tweet> findAll();
    Iterable<Tweet> findAllByUser(User user);
}
