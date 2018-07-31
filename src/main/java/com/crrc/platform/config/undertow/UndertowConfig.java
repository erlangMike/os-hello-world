package com.crrc.platform.config.undertow;


import io.undertow.Undertow;
import io.undertow.servlet.api.DeploymentInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowDeploymentInfoCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author jn
 */
@Configuration
public class UndertowConfig {
    @Value("${customer.server.http.enable}")
    private boolean enableHttp;

    @Bean
    public UndertowServletWebServerFactory servletWebServerFactory() {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        factory.addBuilderCustomizers(new Builder() );
        factory.addDeploymentInfoCustomizers(new Deploy());
        return factory;
    }
    class Deploy implements UndertowDeploymentInfoCustomizer {

        @Override
        public void customize(DeploymentInfo deploymentInfo) {
        }
    }
    class Builder implements UndertowBuilderCustomizer {
        @Override
        public void customize(Undertow.Builder builder) {
            if(enableHttp){
                builder.addHttpListener(8080,"0.0.0.0");
            }
        }
    }

}
