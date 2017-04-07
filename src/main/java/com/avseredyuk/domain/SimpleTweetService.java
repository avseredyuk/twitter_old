package com.avseredyuk.domain;

import com.avseredyuk.repository.TweetRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Anton_Serediuk on 3/31/2017.
 */
public class SimpleTweetService implements TweetService {
    private TweetRepository tweetRepository;

    public SimpleTweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet createTweet(User user, String text) {
        Tweet newTweet = createEmptyTweet();
        newTweet.setText(text);
        return newTweet;
    }

    Tweet createEmptyTweet() {
        return null;
    }


    @Override
    public Iterable findAll() {
        return tweetRepository.findAll();
    }

    @Override
    public void save(Tweet tweet) {
        tweetRepository.save(tweet);
    }

    public void doSomething() {
        try {
            System.out.println("Twitter service working...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
