package com.avseredyuk.web.infrastructure;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anton_Serediuk on 4/10/2017.
 */
public class DispatcherServlet extends HttpServlet {
    private ConfigurableApplicationContext webContext;

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        ConfigurableApplicationContext parentContext =
                (ConfigurableApplicationContext) servletContext.getAttribute("parentContext");

        String webContextName = servletContext.getInitParameter("myWebContext");
        webContext = new ClassPathXmlApplicationContext(new String[] {webContextName}, parentContext);
    }

    @Override
    public void destroy() {
        webContext.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String beanName = getBeanNameFromRequest(req);
        handleRequest(req, resp, beanName);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp, String beanName) throws IOException {
        MyController controller = (MyController) webContext.getBean(beanName);
        if (controller != null) {
            controller.handleRequest(req, resp);
        }
    }

    private String getBeanNameFromRequest(HttpServletRequest req) {
        String requestURL = req.getRequestURI();
        return requestURL.substring(requestURL.lastIndexOf("/"));
    }
}
