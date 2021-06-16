package com.example.demo.services;

import com.example.demo.contract.AddressDto;
import com.example.demo.contract.AddressSummaryDto;
import com.example.demo.contract.PersonDto;
import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.PersonRepository;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeopleDataService {

    final private PersonRepository repository;
    final private AddressRepository addressRepository;
    final private Mapper mapper;
    public PeopleDataService(PersonRepository repository, AddressRepository addressRepository, Mapper mapper) {
        this.repository = repository;
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }

    private void setLocationOnAddresses(int personId, List<AddressSummaryDto> addresses){
        addresses.stream().forEach(a->a.setLocation(getUri(personId, a.getId())));

    }
    private String getUri(int personId, int addressId){
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .pathSegment("people")
                .pathSegment(personId+"")
                .pathSegment("addresses")
                .pathSegment(addressId+"").build().toUriString();
    }


    public int savePerson(Person person){
        Person result = repository.save(person);
        return result.getID();
    }

    public List<PersonDto> getAll(String name){
        List<Person> result;
        if(name == null || name == "")
            result= repository.findAll();
        else result = repository.findByName(name);
        List<PersonDto> res= result.stream()
                .map(x->mapper.map(x, PersonDto.class))
                .collect(Collectors.toList());
        res.stream().forEach(p->setLocationOnAddresses(p.getID(),p.getAddresses()));
        return res;
    }

    public PersonDto getById(int id){
        Person person = repository.findById(id).orElse(null);
        if(person == null) return null;
        PersonDto result = mapper.map(person, PersonDto.class);
        setLocationOnAddresses(result.getID(), result.getAddresses());
        return result;
    }

    public PersonDto update(int id, Person p){
        Person person = repository.findById(id).orElse(null);
        if(person==null)return null;
        person.setAge(p.getAge());
        person.setName(p.getName());
        person.setSurname(p.getSurname());
        repository.save(person);
        return mapper.map(person, PersonDto.class);

    }

    public PersonDto delete(int id){
        Person person = repository.findById(id).orElse(null);
        if(person==null)return null;
        repository.delete(person);
        return mapper.map(person, PersonDto.class);
    }

    public AddressDto saveAddress(int id, Address address) {
        Person person = repository.findById(id).orElse(null);
        if(person==null)return null;
        person.getAddresses().add(address);
        address.setPerson(person);
        repository.save(person);
        addressRepository.save(address);
        return mapper.map(address, AddressDto.class);
    }

    public List<AddressDto> getAddresses(int id) {
        Person person = repository.findById(id).orElse(null);
        if(person==null)return null;
        return person.getAddresses()
                .stream()
                .map(x->mapper.map(x, AddressDto.class))
                .collect(Collectors.toList());
    }

    public AddressDto deleteAddress(int personId, int addressId) {

        Person person = repository.findById(personId).orElse(null);
        if(person==null)return null;
        Address addressToDelete = person
                .getAddresses()
                .stream()
                .filter(a->a.getId()==addressId)
                .findFirst()
                .orElse(null);
        if(addressToDelete == null) return null;
        person.getAddresses().remove(addressToDelete);
        addressRepository.delete(addressToDelete);
        return mapper.map(addressToDelete, AddressDto.class);
    }


    public AddressDto updateAddress(int personId, int addressId, AddressDto address) {
        Person person = repository.findById(personId).orElse(null);
        if(person==null)return null;
        Address addressToUpdate = addressRepository.findById(addressId).orElse(null);
        if(addressToUpdate==null)return null;
        mapper.map(address, addressToUpdate);
        addressToUpdate.setId(addressId);
        addressRepository.save(addressToUpdate);
        return address;
    }
}