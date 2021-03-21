package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonRepository {
    private PersonDb personDb;
    public void save(Person person) {
    }

    public PersonDb getDb() {
        return personDb;
    }
}
