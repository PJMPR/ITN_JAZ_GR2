package com.example.demo;

import org.springframework.stereotype.Component;

@Component

public class Persondb {

    private final Person[] persons;

    public Persondb() {
        persons = new Person[1000];
    }

    public void addPersonToArray(Person person) {
        this.persons[0] = person;
    }

    public Person[] getPersonArray() {
        return this.persons;
    }

}
