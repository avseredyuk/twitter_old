package com.avseredyuk.domain;

/**
 * Created by Anton_Serediuk on 4/5/2017.
 */
public interface TweetService {
    Tweet createTweet(User user, String text);
    Iterable findAll();
    void save(Tweet tweet);
}
