package com.avseredyuk.infrastructure;

import com.avseredyuk.domain.TweetService;
import com.avseredyuk.repository.MemoryTweetRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public class JavaConfig implements Config {
    private final Map<String, Class<?>> classes = new HashMap<>();

    {
        classes.put("tweetRepo", MemoryTweetRepository.class);
        classes.put("tweetService", TweetService.class);
    }

    @Override
    public Class<?> getImpl(String name) {
        return classes.get(name);
    }
}
