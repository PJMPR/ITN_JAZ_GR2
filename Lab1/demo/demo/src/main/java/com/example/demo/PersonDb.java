package com.example.demo;

import org.springframework.stereotype.Component;


@Component
public class PersonDb {
	private Person[] people;

	public PersonDb() {
		people = new Person[1000];
	}

	public Person[] getPersonArray() {
		return people;
	}
}
