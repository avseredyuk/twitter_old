package com.avseredyuk.service;

import com.avseredyuk.domain.Tweet;
import org.junit.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.SecureRandom;

import static org.junit.Assert.*;

/**
 * Created by Anton_Serediuk on 4/10/2017.
 */
public class SimpleTweetServiceTest {
    private static ConfigurableApplicationContext serviceContext;
    private static TweetService tweetService;

    @BeforeClass
    public static void setUp() throws Exception {
        serviceContext = new ClassPathXmlApplicationContext("serviceContext.xml");
        tweetService = (TweetService) serviceContext.getBean("tweetService");
    }

    @Test
    public void saveTweetWithValidTextLength() throws Exception {
        Tweet tweet = tweetService.create(null, getRandomString(100));
        assertTrue(tweetService.save(tweet));
    }

    @Test
    public void saveTweetWithInvalidTextLength() throws Exception {
        Tweet tweet = tweetService.create(null, getRandomString(141));
        assertFalse(tweetService.save(tweet));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        serviceContext.close();
    }

    private String getRandomString(int length) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder( length );
        for( int i = 0; i < length; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

}