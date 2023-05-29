package org.charlie.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.charlie.servlet.DynamicServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

/**
 * @author Charlie-6327
 * @date 2023/5/2
 */
@Component
public class ServletConfig implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic registration = servletContext
                .addServlet("dynamicServlet", DynamicServlet.class);
        registration.addMapping("/dynamic");
        registration.setInitParameter("name", "dynamic");
    }

    // @Bean
    // public ServletContextInitializer servletContextInitializer() {
    //     return servletContext -> {
    //         ServletRegistration.Dynamic registration = servletContext
    //                 .addServlet("dynamicServlet", DynamicServlet.class);
    //         registration.addMapping("/dynamic");
    //         registration.setInitParameter("name", "dynamic");
    //     };
    // }
}
