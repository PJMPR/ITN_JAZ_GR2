package com.example.demo.services;

import com.example.demo.contract.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class PeopleService {

    public List<Person> db = new ArrayList<Person>();


    public List<Person> getAll() {
        return db;
    }

    public int savePerson(Person person) {

        OptionalInt maxId = db.stream().mapToInt(p -> p.getID()).max();
        if (maxId.isPresent())
            person.setID(maxId.getAsInt() + 1);
        else person.setID(1);
        db.add(person);
        return person.getID();
    }

    public Person getById(int id) {
        Person result = getPersonById(id);
        return result;
    }

    public Person update(int id, Person person) {
        Person result = getPersonById(id);
        if (result == null) return null;
        result.setAge(person.getAge());
        result.setName(person.getName());
        result.setSurname(person.getSurname());
        return result;
    }

    private Person getPersonById(int id2) {
        Optional<Person> result = db.stream().filter(p -> p.getID() == id2).findFirst();
        if (!result.isPresent()) return null;
        return result.get();
    }

    public Person deletePerson(int id) {
        Person result = getPersonById(id);
        if (result == null) return null;
        db.remove(result);
        return result;

    }
}
