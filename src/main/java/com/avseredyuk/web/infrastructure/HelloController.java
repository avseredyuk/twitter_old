package com.avseredyuk.web.infrastructure;

import com.avseredyuk.service.TweetService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anton_Serediuk on 4/10/2017.
 */
public class HelloController implements MyController, BeanNameAware, ApplicationContextAware {
    private String beanName;
    private ApplicationContext applicationContext;

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (PrintWriter out = resp.getWriter()) {
            out.println("<b>Hello from HelloController</b><br/>");
            out.println("<b> Bean name:</b> " + beanName + "<br/>");
            TweetService tweetService = (TweetService) applicationContext.getBean("tweetService");
            tweetService.findAll().forEach(t -> out.println("<i>" + t.toString() + "</i><br/>"));
        }
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
