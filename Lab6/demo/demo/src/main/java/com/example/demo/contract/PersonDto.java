package com.example.demo.contract;

import java.util.ArrayList;
import java.util.List;

public class PersonDto {

    int ID;
    String name;
    String surname;
    int age;

    List<AddressSummaryDto> addresses = new ArrayList<AddressSummaryDto>();

    public List<AddressSummaryDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressSummaryDto> addresses) {
        this.addresses = addresses;
    }

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