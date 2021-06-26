
package com.example.demo.controllers;

import com.example.demo.contract.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("homework")// localhost:8080/homework
public class HomeworkController {

    @GetMapping("{someValue}?reqParam={name}") // (HTTP GET) localhost:8080/homework/test
    public ResponseEntity queryParams(@PathVariable("someValue") String value, @RequestParam("name") String name){
        return ResponseEntity.ok("path:" + value +" query:" + name);
    }

    @PostMapping("person")
    public ResponseEntity saveNewPerson(@RequestBody Person person){
        return ResponseEntity.ok(person);
    }

    @PutMapping("person/{someValue}")
    public ResponseEntity putPerson (@RequestBody Person person, @PathVariable ("someValue") String name){

        return ResponseEntity.ok(person);
    }

    @DeleteMapping("person/{someValue}")
    public ResponseEntity deletePerson (@PathVariable ("someValue") String name){
        return ResponseEntity.ok(200);
    }

}
