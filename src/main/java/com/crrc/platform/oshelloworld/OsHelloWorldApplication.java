package com.crrc.platform.oshelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.crrc.platform.hello.*"})
public class OsHelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(OsHelloWorldApplication.class, args);
    }
}
