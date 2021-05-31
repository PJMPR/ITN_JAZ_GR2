package com.example.demo.controllers;


import com.example.demo.contract.Person;
import com.example.demo.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("people")
public class PeopleController {

    private final PeopleService service;

    public PeopleController(PeopleService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping()
    public ResponseEntity savePerson(@RequestBody Person person) {

        int id = service.savePerson(person);

        UriComponents uri = ServletUriComponentsBuilder.fromCurrentContextPath().path(id+"").build();
        return ResponseEntity.created(uri.toUri()).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id) {
        Person result = service.getById(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PutMapping("{id}")
    public ResponseEntity updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
        Person result = service.update(id, person);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePerson(@PathVariable("id") int id) {
        Person result = service.deletePerson(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
