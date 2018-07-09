package com.crrc.platform.config.sql;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author mikejn
 */
@Configuration
@MapperScan(basePackages = "com/crrc/platform/hello/mapper",sqlSessionFactoryRef = "coreSqlSessionFactory")
public class CoreCustomizerConfig {

    @Bean(name = "coreSqlSessionFactory")
    @Primary
    public SqlSessionFactory coreSqlSessionFactory(@Qualifier("coreDataSource") DataSource coreDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(coreDataSource);
/*        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("com.crrc.platform.hello.mapper"));*/
        return sessionFactory.getObject();
    }
}
