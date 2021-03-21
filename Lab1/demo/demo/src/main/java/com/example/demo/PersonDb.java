package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonDb {
    private Person[] personArray;

    public PersonDb() {
        this.personArray = new Person[1000];
    }

    public Person[] getPersonArray() {
        return this.personArray;
    }

    public void addPersonToArray(Person person) {
        this.personArray[0] = person;
    }

}
