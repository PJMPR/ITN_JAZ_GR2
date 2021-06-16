package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String Description;
    Date date;
    String culprit;
    String sufferer;

    @ManyToOne
    Car car;

    public Accident() {
    }

    public Accident(String description, java.util.Date date, String culprit, String sufferer) {
        Description = description;
        this.date = date;
        this.culprit = culprit;
        this.sufferer = sufferer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCulprit() {
        return culprit;
    }

    public void setCulprit(String culprit) {
        this.culprit = culprit;
    }

    public String getSufferer() {
        return sufferer;
    }

    public void setSufferer(String sufferer) {
        this.sufferer = sufferer;
    }
}
