package com.avseredyuk;

import com.avseredyuk.service.SimpleTweetService;
import com.avseredyuk.infrastructure.*;

/**
 * Hello world!
 *
 *
 * getconstructor args
 * CAN BE CREATED BY IoC:
 * SimpleTweetService(TweetRepository)
 *  * addTwitter()
 *  * getTwitters
 */
public class TwitterRunner
{
    public static void main( String[] args ) throws Exception {

        Context ctx = new ApplicationContext(new JavaConfig());

        SimpleTweetService tweetService = ctx.getBean("tweetService");
//        tweetService.doSomething();

//        User user = ctx.getBean("userAdmin");
//        TweetRepository tweetRepository = ctx.getBean("tweetRepository");
//        tweetRepository.save(new Tweet(user, "supertext"));
//        tweetRepository.findAll().forEach(System.out::println);

    }
}
