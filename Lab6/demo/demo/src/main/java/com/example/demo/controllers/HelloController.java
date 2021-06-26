package com.example.demo.controllers;

import com.example.demo.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")// localhost:8080/hello
public class HelloController {


    @GetMapping("exception")
    public ResponseEntity throwException() throws Exception {
        throw new Exception("testowy blad");
    }

    @GetMapping("test") // (HTTP GET) localhost:8080/hello/test
    public ResponseEntity helloWorld(){
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("model")
    public ResponseEntity getNewCar(){
        return ResponseEntity.ok(new Car(
                "Audi",
                "GD0001",
                100000,
                false,
                30000.0
        ));
    }

    @PostMapping("model")
    public ResponseEntity saveNewCar(@RequestBody Car car){
        return ResponseEntity.ok(car);
    }

    @GetMapping("test/{someValue}")// /books/Page1 books/Page2 -> "books/Page{number}"
    public ResponseEntity pathParams(@PathVariable("someValue") String value){
        return ResponseEntity.ok(value);
    }

    @GetMapping("query")
    public ResponseEntity queryParams(@RequestParam("name") String name){
        return ResponseEntity.ok(name);
    }
}