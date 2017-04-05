package com.avseredyuk;

import com.avseredyuk.domain.SimpleTweetService;
import com.avseredyuk.domain.Tweet;
import com.avseredyuk.repository.TweetRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Stream;

/**
 * Created by Anton_Serediuk on 4/3/2017.
 */
public class SpringTwitterRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext repoContext =
                new ClassPathXmlApplicationContext(new String[]{"repoContext.xml"});

        Stream.of(repoContext.getBeanDefinitionNames())
                .map(repoContext.getBeanFactory()::getBeanDefinition)
                .forEach(System.out::println);

        TweetRepository tweetRepository = (TweetRepository) repoContext.getBean("tweetRepository");
        tweetRepository.findAll().forEach(System.out::println);



        ConfigurableApplicationContext serviceContext =
                new ClassPathXmlApplicationContext(new String[]{"serviceContext.xml"}, repoContext);

        Stream.of(serviceContext.getBeanDefinitionNames())
                .map(serviceContext.getBeanFactory()::getBeanDefinition)
                .forEach(System.out::println);

        SimpleTweetService tweetService = (SimpleTweetService)serviceContext.getBean("tweetService");
        tweetService.save(new Tweet(null, "new text"));
        tweetService.doSomething();

        repoContext.close();
        serviceContext.close();


    }
}
