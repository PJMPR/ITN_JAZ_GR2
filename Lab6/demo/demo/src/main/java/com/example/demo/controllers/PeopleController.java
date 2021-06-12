package com.example.demo.controllers;


import com.example.demo.contract.AddressDto;
import com.example.demo.contract.PersonDto;
import com.example.demo.model.Address;
import com.example.demo.model.Person;
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
    public ResponseEntity getAll(@RequestParam(value = "name", required = false) String name) {

        return ResponseEntity.ok(dataService.getAll(name));
    }

    @PostMapping()
    public ResponseEntity savePerson(@RequestBody Person person) {

        int id = dataService.savePerson(person);

        UriComponents uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("people").path(id+"").build();
        return ResponseEntity.created(uri.toUri()).build();
    }

    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable("id") int id) {
        PersonDto result = dataService.getById(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PutMapping("{id}")
    public ResponseEntity updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
        PersonDto result = dataService.update(id, person);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePerson(@PathVariable("id") int id) {
        PersonDto result = dataService.delete(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    // /people/1/addresses
    @PostMapping("{id}/addresses")
    public ResponseEntity addAddress(
            @PathVariable("id") int id,
            @RequestBody Address address
            ){
        AddressDto a = dataService.saveAddress(id, address);
        if(a==null) return ResponseEntity.notFound().build();
        UriComponents uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .pathSegment("people")
                .pathSegment(id+"")
                .pathSegment("addresses")
                .pathSegment(a.getId()+"").build();
        return ResponseEntity.created(uri.toUri()).build();
    }

    @GetMapping("{id}/addresses")
    public ResponseEntity getAddresses(@PathVariable("id") int id){
        List<AddressDto> addresses = dataService.getAddresses(id);
        if(addresses==null)return ResponseEntity.notFound().build();
        return ResponseEntity.ok(addresses);
    }

    @DeleteMapping("{id}/addresses/{address_id}")
    public ResponseEntity deleteAddress(
            @PathVariable("id") int personId,
            @PathVariable("address_id") int addressId
    ){
        AddressDto address = dataService.deleteAddress(personId, addressId);
        if(address == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}/addresses/{address_id}")
    public ResponseEntity updateAddress(
            @PathVariable("id") int personId,
            @PathVariable("address_id") int addressId,
            @RequestBody AddressDto address
    ){
        AddressDto addressDto = dataService.updateAddress(personId, addressId, address);
        if(addressDto==null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
