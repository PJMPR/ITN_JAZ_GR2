package com.example.demo.contract;

import com.example.demo.model.Address;

public class AddressDto {
    int id;
    String city;
    String country;
    String addressLine;
    String postalCode;
    Address.AddressType type;

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

    public Address.AddressType getType() {
        return type;
    }

    public void setType(Address.AddressType type) {
        this.type = type;
    }
}
