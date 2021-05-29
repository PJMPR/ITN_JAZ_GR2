package com.example.demo.contract;


import javax.persistence.*;

@Entity
@NamedQuery(name = "Person.findByName",
        query = "select p from Person p where p.name = ?1")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;
    String name;
    String surname;
    int age;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
