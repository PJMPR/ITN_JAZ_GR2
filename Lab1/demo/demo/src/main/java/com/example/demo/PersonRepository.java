package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonRepository {

    private PersonDb personDb;

    public PersonRepository(PersonDb personDb) {
        this.personDb = personDb;
    }

    public void save(Person person) {
        personDb.addPersonToArray(person);
    }

    public PersonDb getDb() {
        return personDb;
    }

    public void printMe(){
        System.out.println("PersonRepository");
    }
}
