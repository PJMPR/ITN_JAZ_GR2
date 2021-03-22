package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PersonDb {
    private Person[] personArray; //= new Person[1000];


    @Autowired
    public PersonDb() {
        personArray = new Person[1000];
    }

    public Person[] getPersonArray() {
        return this.personArray;
    }

    public void addToArray(Person person) {
        this.personArray[0] = person;

    }
}
