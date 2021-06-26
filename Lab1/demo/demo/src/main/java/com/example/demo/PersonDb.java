package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonDb {

    Person[] returnableArray = new Person[1000];
    int amountOfPeople = 0;

    public Person[] getPersonArray() {
        return returnableArray;
    }

    public void AddPerson(Person person){
        returnableArray[amountOfPeople] = person;
        amountOfPeople++;
    }

}
