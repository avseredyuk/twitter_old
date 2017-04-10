package com.avseredyuk.service;

import com.avseredyuk.domain.Tweet;

/**
 * Created by Anton_Serediuk on 4/10/2017.
 */
public interface TimelineService {
    Iterable<Tweet> getTweets();

}
