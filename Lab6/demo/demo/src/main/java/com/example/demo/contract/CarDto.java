package com.example.demo.contract;


import java.util.ArrayList;
import java.util.List;

public class CarDto {

	int ID;
	List<AccidentSummaryDto> accidents = new ArrayList<AccidentSummaryDto>();
	private String model;
	private String registrationNumber;
	private int milleage;
	private boolean hasAccidents;
	private double price;

	public CarDto() {
	}

	public CarDto(String model, String registrationNumber, int milleage, boolean hasAccidents, double price) {
		this.model = model;
		this.registrationNumber = registrationNumber;
		this.milleage = milleage;
		this.hasAccidents = hasAccidents;
		this.price = price;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public List<AccidentSummaryDto> getAccidents() {
		return accidents;
	}

	public void setAccidents(List<AccidentSummaryDto> accidents) {
		this.accidents = accidents;
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
}
