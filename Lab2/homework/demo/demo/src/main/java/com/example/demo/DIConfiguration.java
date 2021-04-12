package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIConfiguration {

    @Bean
    public DialogService dialogService() {
        return new DialogService(loginMessages());
    }

    @Bean
    public LoginMessages loginMessages() {
        return new LoginMessages();
    }
}