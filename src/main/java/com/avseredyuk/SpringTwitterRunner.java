package com.avseredyuk;

import com.avseredyuk.service.SimpleTweetService;
import com.avseredyuk.domain.Tweet;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Stream;

/**
 * Created by Anton_Serediuk on 4/3/2017.
 */
/* we can create tweet
    tweet
    retweet: w/o text, only share in timeline with link thats not our tweet
    mentions: if u mentioned someone in tweet, this tweet shows in that users timeline
    -- later
    like:
    reply: shows in our timeline
******************
    spring in anno's, not xml
    2 variants of projects, for trash and spring stuff, other is clear project
 */


public class SpringTwitterRunner {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.refresh();
//        System.out.println(ctx.getBean("tweet"));


//        ConfigurableApplicationContext repoContext =
//                new ClassPathXmlApplicationContext("repoContext.xml");
//
//        Stream.of(repoContext.getBeanDefinitionNames())
//                .map(repoContext.getBeanFactory()::getBeanDefinition)
//                .forEach(System.out::println);
//
//        TweetRepository tweetRepository = (TweetRepository) repoContext.getBean("tweetRepository");
//        tweetRepository.findAll().forEach(System.out::println);


        ConfigurableApplicationContext serviceContext =
                new ClassPathXmlApplicationContext("serviceContext.xml");

        Stream.of(serviceContext.getBeanDefinitionNames())
                .map(serviceContext.getBeanFactory()::getBeanDefinition)
                .forEach(System.out::println);

        SimpleTweetService tweetService = (SimpleTweetService) serviceContext.getBean("tweetService");
        tweetService.save(new Tweet(null, "1111"));
        tweetService.save(new Tweet(null, "2222"));
        System.out.println(tweetService);
        System.out.println(tweetService.findAll());

//
//        System.out.println(serviceContext.getBean("temp"));
//
//        System.out.println(repoContext.getBean("tweetRepository"));
//        System.out.println(repoContext.getBean("tweetRepository"));
//        System.out.println(repoContext.getBean("tweetRepository"));
//
//
//
//        repoContext.close();

//        serviceContext.close();


    }
}
