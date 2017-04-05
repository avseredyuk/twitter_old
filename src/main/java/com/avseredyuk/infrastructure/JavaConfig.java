package com.avseredyuk.infrastructure;

import com.avseredyuk.domain.SimpleTweetService;
import com.avseredyuk.domain.User;
import com.avseredyuk.repository.MemoryTweetRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anton_Serediuk on 3/30/2017.
 */
public class JavaConfig implements Config {
    private final Map<String, Class<?>> classes = new HashMap<>();

    {
        classes.put("tweetRepository", MemoryTweetRepository.class);
        classes.put("tweetService", SimpleTweetService.class);
        classes.put("userAdmin", User.class);
    }

    @Override
    public Class<?> getImpl(String name) {
        return classes.get(name);
    }

    @Override
    public Collection<Class<?>> getList() {
        return classes.values();
    }
}
