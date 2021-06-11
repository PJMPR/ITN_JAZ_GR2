package com.example.demo.model;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Address.getAddressById", query = "select a from Address a where a.person.ID=:id")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String city;
    String country;
    String addressLine;
    String postalCode;
    AddressType type;

    @ManyToOne
    Person person;

    public Address() {
    }

    public Address(String city, String country, String addressLine, String postalCode, AddressType type) {
        this.city = city;
        this.country = country;
        this.addressLine = addressLine;
        this.postalCode = postalCode;
        this.type = type;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public enum AddressType{
        contact, home, office
    }
}
