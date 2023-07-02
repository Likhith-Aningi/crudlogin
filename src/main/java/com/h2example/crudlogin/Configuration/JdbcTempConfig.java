package com.h2example.crudlogin.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcTempConfig {
    @Value("${spring.datasource.driver-class-name}")
    String clasName;
    @Value("${spring.datasource.url}")
    String url;
    @Value ("${spring.datasource.password}") String pwd;
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(clasName);
        dataSource.setUrl(url);
        dataSource.setUsername("root");
        dataSource.setPassword(pwd);
        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate namedJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
