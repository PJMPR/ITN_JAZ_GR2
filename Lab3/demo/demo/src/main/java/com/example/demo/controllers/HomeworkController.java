package com.example.demo.controllers;

import com.example.demo.contract.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("homework")
public class HomeworkController {
    @GetMapping()
    public ResponseEntity x(){
        return ResponseEntity.ok("x");
    }

    @GetMapping("{someValue}")
    public ResponseEntity params(@PathVariable("someValue") String value,
                                 @RequestParam("query") String query){
        return ResponseEntity.ok("path:" + value + " query:" + query);
    }

    @PostMapping("person")
    public ResponseEntity newPerson (@RequestBody Person person) {
        return ResponseEntity.ok(person);

    }

    @PutMapping("person/{somePerson}")
    public ResponseEntity oldPerson (@PathVariable("somePerson") String number,
                                     @RequestBody Person person){
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("person/{somePerson}")
    public ResponseEntity somePerson (){
        return ResponseEntity.ok("");
    }
}