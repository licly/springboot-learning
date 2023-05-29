package org.charlie.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

import java.time.Duration;

/**
 * @author Charlie-6327
 * @date 2023/5/1
 */

// @Component
public class TomcatWebServerFactoryCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.setPort(8080);
        factory.addConnectorCustomizers(connector ->
                connector.setAsyncTimeout(Duration.ofSeconds(20).toMillis()));
    }
}
