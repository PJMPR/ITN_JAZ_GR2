package com.example.pop2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DIConfiguration {

    @Value("${my.custom.property:To jest domyślna wiadomość}")
    private String welcomeMessage;

    @Bean
    public CarPOJO car(@Value("${my.own.variable}") boolean create){
        if (create)
            return new CarPOJO("","",100,false,0.00);
        else
            return null;
    }

    @Bean
    public List<String> defaultData(){

        System.out.println(welcomeMessage);
        return List.of("String1", "String2", "String3", "String4", "String5");
    }
}
