package com.example.demo.controllers;

import com.example.demo.contract.WeatherMapApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("weather")
public class WeatherController {

    @GetMapping("{city}")
    public ResponseEntity getByCity(@PathVariable("city") String city){

        WebClient webClient = WebClient.create("http://api.openweathermap.org");

        WeatherMapApiDto weatherInfo = webClient.get().uri("/data/2.5/weather?q=" +
                city +
                "&appid=cb6c6d99aa8697402c79bac521cf7008")
                .exchangeToMono(response->{
                    if(response.statusCode().is2xxSuccessful())
                        return response.bodyToMono(WeatherMapApiDto.class);
                    else
                        return response.createException().flatMap(Mono::error);
                }).block();

        return ResponseEntity.ok(weatherInfo);
    }

}
