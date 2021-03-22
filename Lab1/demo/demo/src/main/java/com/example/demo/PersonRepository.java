package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PersonRepository {

    PersonDb personDb;

    public PersonRepository(PersonDb personDb) {
        this.personDb = personDb;
    }

    public void save(Person person){
        personDb.addToArray(person);
    }

    public PersonDb getDb() {
        return personDb;
    }


}
