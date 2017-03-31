package com.avseredyuk;

import com.avseredyuk.domain.Tweet;
import com.avseredyuk.domain.TweetService;
import com.avseredyuk.domain.User;
import com.avseredyuk.infrastructure.*;
import com.avseredyuk.repository.MemoryTweetRepository;
import com.avseredyuk.repository.TweetRepository;

/**
 * Hello world!
 *
 *
 * getconstructor args
 * CAN BE CREATED BY IoC:
 * TweetService(TweetRepository)
 *  * addTwitter()
 *  * getTwitters
 */
public class TwitterRunner
{
    public static void main( String[] args ) throws Exception {

        Context ctx = new ApplicationContext(new JavaConfig());

        TweetService tweetService = ctx.getBean("tweetService");
        tweetService.doSomething();

        TweetRepository tweetRepository = ctx.getBean("tweetRepo");
        tweetRepository.save(new Tweet(new User("asdf"), "asdf"));
        tweetRepository.findAll().forEach(System.out::println);

    }
}
