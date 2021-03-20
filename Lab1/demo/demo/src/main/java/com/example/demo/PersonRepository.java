package com.example.demo;

import org.springframework.stereotype.Component;

@Component

public class PersonRepository {
    private Persondb persondb;

    public PersonRepository(Persondb persondb){
        this.persondb = persondb;
    }

    public void save (Person person){
        persondb.addToArray(person);

    }

    public Persondb getDb(){
        return persondb;
    }
}
