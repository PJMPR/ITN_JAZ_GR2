package com.example.demo.services;

import com.example.demo.contract.PersonDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class PeopleService {

    public List<PersonDto> db = new ArrayList<PersonDto>();


    public List<PersonDto> getAll() {
        return db;
    }

    public int savePerson(PersonDto personDto) {

        OptionalInt maxId = db.stream().mapToInt(p -> p.getID()).max();
        if (maxId.isPresent())
            personDto.setID(maxId.getAsInt() + 1);
        else personDto.setID(1);
        db.add(personDto);
        return personDto.getID();
    }

    public PersonDto getById(int id) {
        PersonDto result = getPersonById(id);
        return result;
    }

    public PersonDto update(int id, PersonDto personDto) {
        PersonDto result = getPersonById(id);
        if (result == null) return null;
        result.setAge(personDto.getAge());
        result.setName(personDto.getName());
        result.setSurname(personDto.getSurname());
        return result;
    }

    private PersonDto getPersonById(int id2) {
        Optional<PersonDto> result = db.stream().filter(p -> p.getID() == id2).findFirst();
        if (!result.isPresent()) return null;
        return result.get();
    }

    public PersonDto deletePerson(int id) {
        PersonDto result = getPersonById(id);
        if (result == null) return null;
        db.remove(result);
        return result;

    }
}
