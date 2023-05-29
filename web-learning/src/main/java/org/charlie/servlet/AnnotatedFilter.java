package org.charlie.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author Charlie-6327
 * @date 2023/5/2
 */

@Slf4j
@WebFilter(filterName = "annotatedFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "name", value = "annotated"),
        @WebInitParam(name = "code", value = "123456")
})
public class AnnotatedFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("java filter init.");
        String name = filterConfig.getInitParameter("name");
        String code = filterConfig.getInitParameter("code");
        log.info("name is : {}", name);
        log.info("code is : {}", code);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("filter processing");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("filter destroy");
    }
}
