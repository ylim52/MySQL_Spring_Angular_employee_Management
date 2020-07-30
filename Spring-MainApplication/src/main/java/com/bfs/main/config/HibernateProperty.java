package com.bfs.main.config;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration @Component
@Getter @Setter
public class HibernateProperty {

    @Value("${database.hibernate.url}")
    private String url;

    @Value("${database.hibernate.driver}")
    private String driver;

    @Value("${database.hibernate.username}")
    private String username;

    @Value("${database.hibernate.password}")
    private String password;

    @Value("${database.hibernate.dialect}")
    private String dialect;

    @Value("${database.hibernate.showsql}")
    private String showsql;
}