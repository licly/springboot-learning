package org.charlie.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Charlie-6327
 * @date 2023/5/2
 */
public class DynamicServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = getInitParameter("name");
        resp.getOutputStream().println("name is : " + name);
    }
}
