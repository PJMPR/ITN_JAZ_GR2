package com.example.demo.controllers;

import com.example.demo.contract.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("homework")
public class HomeworkController {

    @GetMapping("{path}")
    public ResponseEntity pathAndParam(@PathVariable("path") String path, @PathParam("query") String query){

        return ResponseEntity.ok("path:" + path + " query:" + query);
    }

    @PostMapping("person")
    public ResponseEntity postingPerson(@RequestBody Person person){

        return ResponseEntity.ok(person);
    }

    @PutMapping("person/{number}")
    public ResponseEntity puttingPerson(@PathVariable("number") String pathNumber, @RequestBody Person person){

        return ResponseEntity.ok(person);
    }

    @DeleteMapping("person/{number}")
    public ResponseEntity deletingPerson(@PathVariable("number") String pathNumber){

        return ResponseEntity.ok("");
    }
}
