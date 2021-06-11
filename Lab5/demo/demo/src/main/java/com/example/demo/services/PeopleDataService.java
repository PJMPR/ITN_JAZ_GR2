package com.example.demo.services;

import com.example.demo.contract.AddressDto;
import com.example.demo.contract.PersonDto;
import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.PersonRepository;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Service;
import static java.util.stream.Collectors.toList;
import java.util.List;

@Service
public class PeopleDataService {

    final private PersonRepository repository;
    final private Mapper mapper;
    final private AddressRepository addressRepository;
    public PeopleDataService(
            PersonRepository repository,
            Mapper mapper,
            AddressRepository addressRepository
    ) {
        this.addressRepository=addressRepository;
        this.mapper=mapper;
        this.repository = repository;
    }

    public int savePerson(PersonDto personDto){
        PersonDto result =mapper.map( repository.save(mapper.map( personDto, Person.class)), PersonDto.class);
        return result.getID();
    }

    public List<PersonDto> getAll(String name){
        if(name == null || name == "")
            return repository.findAll().stream().map(x-> mapper.map(x, PersonDto.class)).collect(toList());
        return repository.findByName(name).stream().map(x-> mapper.map(x, PersonDto.class)).collect(toList());
    }

    public PersonDto getById(int id){
        Person person = repository.findById(id).orElse(null);
        PersonDto personDto = null;
        if(person!=null)personDto=mapper.map(person, PersonDto.class);
        return personDto;
    }

    public PersonDto update(int id, PersonDto p){
        PersonDto personDto = getById(id);
        if(personDto ==null)return null;
        personDto.setAge(p.getAge());
        personDto.setName(p.getName());
        personDto.setSurname(p.getSurname());
        repository.save(mapper.map(personDto, Person.class));
        return personDto;

    }

    public PersonDto delete(int id){
        PersonDto personDto = getById(id);
        if(personDto ==null)return null;
        repository.delete(mapper.map(personDto, Person.class));
        return personDto;
    }

    public Address saveAddress(int id, AddressDto address) {

        Person person = repository.findById(id).orElse(null);
        if(person==null)return null;
        Address address1 = mapper.map(address, Address.class);
        person.getAddresses().add(address1);
        address1.setPerson(person);
        addressRepository.save(address1);
        return address1;
    }

    public List<Address> getPersonAddresses(int id){
        List<Address> result = addressRepository.getAddressById(id);
        return result;
    }
}
