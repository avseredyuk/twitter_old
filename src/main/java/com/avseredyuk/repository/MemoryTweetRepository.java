package com.avseredyuk.repository;

import com.avseredyuk.domain.Tweet;
import com.avseredyuk.domain.User;
import com.avseredyuk.infrastructure.Benchmark;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
@Repository("tweetRepository")
public class MemoryTweetRepository implements TweetRepository {
    private final List<Tweet> tweets = new ArrayList<>();

    @PostConstruct
    public void init() {
        tweets.add(new Tweet(new User("vasya"), "vasyliy rocks!"));
        tweets.add(new Tweet(new User("gena"), "gena rulez!!"));
    }

    @Override
    @Benchmark
    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    @Override
    public Iterable<Tweet> findAll() {
        return new ArrayList<>(tweets);
    }

    @Override
    public Iterable<Tweet> findAllByUser(User user) {
        return tweets.stream()
                .filter(t -> user.getName().equals(t.getUser().getName()))
                .collect(Collectors.toList());
    }
}
