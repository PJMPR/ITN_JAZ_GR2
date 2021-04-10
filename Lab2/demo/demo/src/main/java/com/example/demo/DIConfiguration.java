package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIConfiguration {

    @Bean
    public DbContext dbContext(
            @Value("${db.mysql.url}") String url,
            @Value("${db.mysql.user}") String user,
            @Value("${db.mysql.password}") String password,
            @Value("${db.mysql.create}") boolean create
    ){
        if(create)
            return new DbContext(url,user,password);
        else return null;
    }


}
