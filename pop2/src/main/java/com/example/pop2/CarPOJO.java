package com.example.pop2;

public class CarPOJO {
    private String model;
    private String registrationNumber;
    private int milleage;
    private boolean hasAccidents;
    private double price;

    public CarPOJO(String model, String registrationNumber, int milleage, boolean hasAccidents, double price) {
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.milleage = milleage;
        this.hasAccidents = hasAccidents;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getMilleage() {
        return milleage;
    }

    public void setMilleage(int milleage) {
        this.milleage = milleage;
    }

    public boolean isHasAccidents() {
        return hasAccidents;
    }

    public void setHasAccidents(boolean hasAccidents) {
        this.hasAccidents = hasAccidents;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String printSomething() {
        return "model=" +
                model +
                "; registrationNumber=" +
                registrationNumber +
                "; milleage=" +
                milleage+
                "; hasAccidents=" +
                hasAccidents+
                "; price=" +
                price;
    }
}
