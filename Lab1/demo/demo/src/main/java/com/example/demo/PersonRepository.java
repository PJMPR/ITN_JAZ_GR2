package com.example.demo;

public class PersonRepository {

    PersonDb database;
    PersonRepository(PersonDb database){
        this.database = database;
    }
    public void save (Person person){
        database.AddPerson(person);
    }

    public PersonDb getDb(){
        return database;
    }

}
