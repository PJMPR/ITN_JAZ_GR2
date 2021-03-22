package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class PersonDb {
    private Person[] personArray = new Person[999];

    public PersonDb() {
    }

    public Person[] getPersonArray() {
        return personArray;
    }

    public void setPersonArray(Person[] personArray) {
        this.personArray = personArray;
    }
}
