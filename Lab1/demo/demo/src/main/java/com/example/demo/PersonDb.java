package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonDb {
    Person[] person = new Person[1000];

    public Person[] getPersonArray() {
        return new Person[0];
    }
}
