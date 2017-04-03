package com.avseredyuk;

import com.avseredyuk.repository.TweetRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Anton_Serediuk on 4/3/2017.
 */
public class SpringTwitterRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring.xml");

        TweetRepository tweetRepository = (TweetRepository) ctx.getBean("tweetRepository");
        tweetRepository.findAll().forEach(System.out::println);

    }
}
