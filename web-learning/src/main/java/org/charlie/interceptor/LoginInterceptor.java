package org.charlie.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author Charlie-6327
 * @date 2023/5/2
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // HttpSession session = request.getSession();
        // String userSession = (String) session.getAttribute("userSession");
        // if (userSession == null) {
        //     response.sendRedirect("/login");
        //     return false;
        // } else {
        //     return true;
        // }
        return true;
    }

}
