package com.example.demo.controllers;


import com.example.demo.contract.AddressDto;
import com.example.demo.contract.PersonDto;
import com.example.demo.model.Address;
import com.example.demo.services.PeopleDataService;
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
    public ResponseEntity<List<PersonDto>> getAll(@RequestParam(value = "name", required = false) String name) {

        return ResponseEntity.ok(dataService.getAll(name));
    }

    @PostMapping()
    public ResponseEntity savePerson(@RequestBody PersonDto personDto) {

        int id = dataService.savePerson(personDto);

        UriComponents uri = ServletUriComponentsBuilder.fromCurrentContextPath().pathSegment("people/").pathSegment(id+"").build();
        return ResponseEntity.created(uri.toUri()).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonDto> getById(@PathVariable("id") int id) {
        PersonDto result = dataService.getById(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PutMapping("{id}")
    public ResponseEntity updatePerson(@PathVariable("id") int id, @RequestBody PersonDto personDto) {
        PersonDto result = dataService.update(id, personDto);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePerson(@PathVariable("id") int id) {
        PersonDto result = dataService.delete(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @PostMapping("{id}/addresses")
    public ResponseEntity addAddress(@PathVariable("id") int id, @RequestBody AddressDto address){

        Address entity = dataService.saveAddress(id, address);
        if(entity==null)return  ResponseEntity.notFound().build();
        UriComponents uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .pathSegment("people")
                .pathSegment(id+"")
                .pathSegment("addresses")
                .pathSegment(entity.getId()+"")
                .build();
        return ResponseEntity.created(uri.toUri()).build();
    }

    @GetMapping("{id}/addresses")
    public ResponseEntity getAddresses(@PathVariable("id") int id){
        return ResponseEntity.ok(dataService.getPersonAddresses(id));
    }
}
