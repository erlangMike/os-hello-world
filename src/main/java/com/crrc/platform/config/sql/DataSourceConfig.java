package com.crrc.platform.config.sql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author mikejn
 */
@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.core.url}")
    private String url;

    @Value("${spring.datasource.core.username}")
    private String username;


    @Value("${spring.datasource.core.password}")
    private String password;

    @Value("${spring.datasource.core.driverClass}")
    private String driverClass;

    @Bean(name = "coreDataSource")
    @Qualifier("coreDataSource")
    @Primary
    public DataSource coreDataSource() {
        HikariConfig config = new HikariConfig();
//        config.setDataSourceClassName("com.mysql.cj.jdbc.MysqlDataSource");
        config.setJdbcUrl(url);
        config.setDriverClassName(driverClass);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setConnectionTestQuery("SELECT 1");

        HikariDataSource ds = new HikariDataSource(config);
/*
        ds.setJdbcUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driverClass);*/
        return ds;
    }

    @Bean(name = "coreTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager(@Qualifier("coreDataSource") DataSource coreDataSource) {
        return new DataSourceTransactionManager(coreDataSource);
    }

/*    @Bean(name = "ruleDataSource")
    @Qualifier("ruleDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.rule")
    public DataSource ruleDataSource() {
        return DataSourceBuilder.create().build();
    }*/
}
