package com.avseredyuk.service;

import com.avseredyuk.domain.Tweet;
import com.avseredyuk.domain.User;

/**
 * Created by Anton_Serediuk on 4/5/2017.
 */
public interface TweetService {
    Tweet create(User user, String text);
    Iterable<Tweet> findAll();
    boolean save(Tweet tweet);
}
