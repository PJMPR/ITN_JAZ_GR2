package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDb {
    Person[] people = new Person[1000];

    public Person[] getPersonArray() {
        return people;
    }
}
