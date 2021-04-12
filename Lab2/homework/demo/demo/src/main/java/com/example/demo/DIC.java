package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIC {

    @Bean
    public DialogService dialogService() {
        return new DialogService(loginMessages());
    }

    @Bean
    public LoginMessages loginMessages() {
        return new LoginMessages();
    }
}