package com.example.demo.controllers;


import com.example.demo.contract.Person;
import com.example.demo.services.PeopleDataService;
import com.example.demo.services.PeopleService;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.List;

@RestController
@RequestMapping("people")
public class PeopleController {

    private final PeopleDataService dataService;

    public PeopleController(PeopleDataService dataService) {

        this.dataService = dataService;
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getAll(@RequestParam(value = "name", required = false) String name) {

        return ResponseEntity.ok(dataService.getAll(name));
    }

    @PostMapping()
    public ResponseEntity savePerson(@RequestBody Person person) {

        int id = dataService.savePerson(person);

        UriComponents uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("people").path(id+"").build();
        return ResponseEntity.created(uri.toUri()).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id) {
        Person result = dataService.getById(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PutMapping("{id}")
    public ResponseEntity updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
        Person result = dataService.update(id, person);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePerson(@PathVariable("id") int id) {
        Person result = dataService.delete(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
