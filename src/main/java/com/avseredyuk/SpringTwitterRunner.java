package com.avseredyuk;

import com.avseredyuk.domain.Tweet;
import com.avseredyuk.domain.TweetService;
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
                new ClassPathXmlApplicationContext(new String[]{"spring.xml"});

        Stream.of(repoContext.getBeanDefinitionNames())
                .map(repoContext.getBeanFactory()::getBeanDefinition)
                .forEach(System.out::println);

        TweetRepository tweetRepository = (TweetRepository) repoContext.getBean("tweetRepository");
        tweetRepository.findAll().forEach(System.out::println);



        ConfigurableApplicationContext serviceContext =
                new ClassPathXmlApplicationContext(new String[]{"serviceConfig.xml"}, repoContext);

        Stream.of(serviceContext.getBeanDefinitionNames())
                .map(serviceContext.getBeanFactory()::getBeanDefinition)
                .forEach(System.out::println);

        TweetService tweetService = (TweetService)serviceContext.getBean("tweetService");
        tweetService.doSomething();



    }
}
