package com.example.demo;

import org.springframework.stereotype.Component;
@Component
public class Persondb {

    private Person[] person;

    public Persondb() {
        person = new Person[1000];
    }

    public Person[] getPersonArray() {
        return person;
    }
}
