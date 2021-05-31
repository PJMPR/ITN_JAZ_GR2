package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("homework")
@RestController
public class HomeworkController {

    @DeleteMapping("person/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        return ResponseEntity.ok().build();
    }

}
