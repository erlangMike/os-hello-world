package com.crrc.platform.config.sql;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean(name = "coreDataSource")
    @Qualifier("coreDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.hello")
    public DataSource coreDataSource() {
        return DataSourceBuilder.create().build();
    }
/*    @Bean(name = "ruleDataSource")
    @Qualifier("ruleDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.rule")
    public DataSource ruleDataSource() {
        return DataSourceBuilder.create().build();
    }*/
}
