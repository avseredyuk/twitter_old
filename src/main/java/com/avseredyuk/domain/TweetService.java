package com.avseredyuk.domain;

import com.avseredyuk.repository.TweetRepository;

/**
 * Created by Anton_Serediuk on 3/31/2017.
 */
public class TweetService {
    private TweetRepository tweetRepository;

    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
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
