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

    @GetMapping("{location}")
    public ResponseEntity params(@PathVariable("location") String location,
                                 @RequestParam("query") String query){
        return ResponseEntity.ok("path:" + location + " query:" + query);
    }

    @PostMapping("person")
    public ResponseEntity postPerson(@RequestBody Person person) {
        return ResponseEntity.ok(person);
    }

    @PutMapping("person/{id}")
    public ResponseEntity updatePerson(@PathVariable("id") String id, @RequestBody Person person) {
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("person/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") String id) {
        return ResponseEntity.ok("");
    }