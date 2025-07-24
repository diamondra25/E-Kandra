package com.freelace.demo;


import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcatFactory = new TomcatServletWebServerFactory();
        tomcatFactory.addConnectorCustomizers(connector -> {
            // Configurer la limite du nombre maximum de fichiers
            connector.setMaxParameterCount(10000); // exemple
            // ou configurer FileUpload limits via MultipartConfigElement
        });
        return tomcatFactory;
    }
}
