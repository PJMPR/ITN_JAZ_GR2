package com.example.pop2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Pop2Application implements CommandLineRunner {


    CarPOJO car;
    List<String> defaultData;

        public Pop2Application(CarPOJO car, List<String> defaultData) {
        this.car = car;
        this.defaultData = defaultData;
    }

    public static void main(String[] args) {
        SpringApplication.run(Pop2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(car.printSomething());
        System.out.println(defaultData);
    }
}
