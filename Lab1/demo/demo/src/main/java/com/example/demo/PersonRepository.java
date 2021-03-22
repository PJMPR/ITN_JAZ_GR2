package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonRepository {
    private Persondb personDb;

    public PersonRepository(Persondb personDb) {
        this.personDb = personDb;
    }

    public void save(Person person) {
        personDb.getPersonArray()[0] = person;
    }

    public Persondb getDb() {
        return personDb;
    }
}