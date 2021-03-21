package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonDb {

    private Person[] personArray;

    public PersonDb() {
        personArray = new Person[1000];
    }

    public void addPersonToArray(Person person) {
        this.personArray[0] = person;
    }

    public Person[] getPersonArray() {
        return this.personArray;
    }

    public void printMe(){
        System.out.println("PersonDb");
    }
}
