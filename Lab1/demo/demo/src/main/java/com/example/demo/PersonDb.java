package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonDb {
    private final Person[] ppl;

    public PersonDb(){
        ppl = new Person[1000];
    }

    public void addPersontoArray(Person person){
        this.ppl[0] = person;
    }

    public Person[] getPersonArray(){
        return this.ppl;
    }
}
