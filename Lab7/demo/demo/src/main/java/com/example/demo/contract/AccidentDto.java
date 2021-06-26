package com.example.demo.contract;

import java.util.Date;

public class AccidentDto {
    int id;
    String Description;
    Date date;
    String culprit;
    String sufferer;

    public AccidentDto() {
    }

    public AccidentDto(String description, Date date, String culprit, String sufferer) {
        Description = description;
        this.date = date;
        this.culprit = culprit;
        this.sufferer = sufferer;
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
