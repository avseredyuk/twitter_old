package com.avseredyuk;

import com.avseredyuk.infrastructure.InitialContext;
import com.avseredyuk.infrastructure.JavaConfig;
import com.avseredyuk.repository.MemoryTweetRepository;
import com.avseredyuk.repository.TweetRepository;

/**
 * Hello world!
 *
 */
public class TwitterRunner
{
    public static void main( String[] args ) throws InstantiationException, IllegalAccessException {

        InitialContext ctx = new InitialContext(new JavaConfig());

        TweetRepository tweetRepository = (TweetRepository) ctx.lookup("tweetRepo");

//        TweetRepository tweetRepository = new MemoryTweetRepository();
        tweetRepository.findAll().forEach(System.out::println);
    }
}
