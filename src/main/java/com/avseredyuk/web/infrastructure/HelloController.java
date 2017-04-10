package com.avseredyuk.web.infrastructure;

import org.springframework.beans.factory.BeanNameAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anton_Serediuk on 4/10/2017.
 */
public class HelloController implements MyController, BeanNameAware {
    private String beanName;

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (PrintWriter out = resp.getWriter()) {
            out.println("<b>Hello from HelloController</b><br/>");
            out.println("<b>" + beanName + "</b>");
        }
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
