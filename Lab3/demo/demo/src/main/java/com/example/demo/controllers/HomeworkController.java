package com.example.demo.controllers;

import com.example.demo.contract.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("homework")// localhost:8080/homework
public class HomeworkController {

    @GetMapping("{path}")// /books/Page1 books/Page2 -> "books/Page{number}"
    public ResponseEntity pathParams(@PathVariable("path") String path, @RequestParam("query") String query){

        return ResponseEntity.ok("path:" + path + " query:" + query);
    }

    @PostMapping("person")
    public ResponseEntity postPerson(@RequestBody Person person){
        return ResponseEntity.ok(person);
    }

    @PutMapping("person/{number}")
    public ResponseEntity putPerson (@PathVariable("number") String number,
                                     @RequestBody Person person){
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("person/{number}")
    public ResponseEntity deletePerson(@PathVariable("number") String number) {
        return ResponseEntity.ok("");
    }
}
