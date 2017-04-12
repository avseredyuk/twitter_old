package com.avseredyuk.service;

import com.avseredyuk.domain.Tweet;
import com.avseredyuk.domain.User;
import com.avseredyuk.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

/**
 * Created by Anton_Serediuk on 3/31/2017.
 */
@Service("tweetService")
public class SimpleTweetService implements TweetService {
    private TweetRepository tweetRepository;

    @Autowired
    public SimpleTweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet create(User user, String text) {
        Tweet newTweet = createEmptyTweet();
        newTweet.setText(text);
        return newTweet;
    }

    @Lookup
    Tweet createEmptyTweet() {
        return null;
    }

    @Override
    public Iterable<Tweet> findAll() {
        return tweetRepository.findAll();
    }

    @Override
    public Iterable<Tweet> findAllByUser(User user) {
        return tweetRepository.findAllByUser(user);
    }

    @Override
    public boolean save(Tweet tweet) {
        if (tweet.getText().length() <= Tweet.TWEET_MAX_TEXT_LENGTH) {
            tweetRepository.add(tweet);
            return true;
        } else {
            return false;
        }
    }

}
