package com.crrc.platform.oshelloworld;

import com.crrc.platform.config.cors.CorsConfigAll;
import com.crrc.platform.config.sql.DataSourceConfig;
import com.crrc.platform.config.undertow.UndertowConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author mikejn
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.crrc.platform.hello.*"},basePackageClasses = {DataSourceConfig.class, CorsConfigAll.class, UndertowConfig.class})
public class OsHelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(OsHelloWorldApplication.class, args);
    }
}
