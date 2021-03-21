package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonRepository {
    private PersonDb personDb;

    public PersonRepository(PersonDb personDb) {
        this.personDb = personDb;
    }

    public void save(Person person) {
        personDb.getPersonArray()[0] = person;
    }

    public PersonDb getDb() {
        return personDb;
    }
}
