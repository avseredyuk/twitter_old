package com.avseredyuk.web.infrastructure;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Anton_Serediuk on 4/10/2017.
 */
public class ApplicationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String webContextNames = servletContext.getInitParameter("contextConfigLocation");
        String[] contextNames = webContextNames.split(" ");
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(contextNames);
        servletContext.setAttribute("parentContext", ctx);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ConfigurableApplicationContext ctx =
                (ConfigurableApplicationContext)
                        servletContextEvent.getServletContext().getAttribute("parentContext");
        ctx.close();
    }
}
