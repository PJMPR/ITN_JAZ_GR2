package com.example.demo.services;

import com.example.demo.contract.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleDataService {

    final private PersonRepository repository;

    public PeopleDataService(PersonRepository repository) {
        this.repository = repository;
    }

    public int savePerson(Person person){
        Person result = repository.save(person);
        return result.getID();
    }

    public List<Person> getAll(String name){
        if(name == null || name == "")
            return repository.findAll();
        return repository.findByName(name);
    }

    public Person getById(int id){
        Person person = repository.findById(id).orElse(null);
        return person;
    }

    public Person update(int id, Person p){
        Person person = getById(id);
        if(person==null)return null;
        person.setAge(p.getAge());
        person.setName(p.getName());
        person.setSurname(p.getSurname());
        repository.save(person);
        return person;

    }

    public Person delete(int id){
        Person person = getById(id);
        if(person==null)return null;
        repository.delete(person);
        return person;
    }
}
