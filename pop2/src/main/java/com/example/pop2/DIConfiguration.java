package com.example.pop2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DIConfiguration {

    @Bean
    public CarPOJO car(){
        return new CarPOJO("","",100,false,0.00);
    }

    @Bean
    public List<String> defaultData(){
        return List.of("String1", "String2", "String3", "String4", "String5");
    }
}
