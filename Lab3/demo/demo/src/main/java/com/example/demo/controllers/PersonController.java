package com.example.demo.controllers;

import com.example.demo.contract.Car;
import com.example.demo.contract.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("homework")
public class PersonController {

    @GetMapping("{path}")
    public ResponseEntity pathParams(@PathVariable("path") String path, @RequestParam("query") String query) {
        return ResponseEntity.ok("path:" + path + " query:" + query);
    }

    @PostMapping("person")
    public ResponseEntity saveNewPerson(@RequestBody Person person) {
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("person/{somePerson}")
    public ResponseEntity deletePerson(@PathVariable("somePerson") String somePerson) {
        return ResponseEntity.ok("");
    }

    @PutMapping("person/{somePerson}")
    public ResponseEntity putPerson(@PathVariable("somePerson") String somePerson, @RequestBody Person person) {
        return ResponseEntity.ok(person);
    }


}
