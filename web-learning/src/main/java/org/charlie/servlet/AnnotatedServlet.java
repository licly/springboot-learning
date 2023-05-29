package org.charlie.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Charlie-6327
 * @date 2023/5/2
 */

@WebServlet(name = "annotatedServlet", urlPatterns = "/annotated", asyncSupported = true, initParams = {
        @WebInitParam(name = "name", value = "charlie"),
        @WebInitParam(name = "address", value = "beijing")
})
public class AnnotatedServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = getInitParameter("name");
        String address = getInitParameter("address");

        resp.getOutputStream().println("name is : " + name);
        resp.getOutputStream().println("address is : " + address);
    }
}
