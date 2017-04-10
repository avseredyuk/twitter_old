package com.avseredyuk.web.infrastructure;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anton_Serediuk on 4/10/2017.
 */
public interface MyController {
    void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
