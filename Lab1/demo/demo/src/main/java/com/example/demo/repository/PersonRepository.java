package com.example.demo.repository;

import com.example.demo.model.Person;
import com.example.demo.model.PersonDb;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonRepository {

    private final PersonDb personDb;

    public PersonRepository(PersonDb personDb) {
        this.personDb = personDb;
    }

    public void save(Person person) {
        Person[] sourceArray = personDb.getPersonArray();
        List<Person> targetList = new ArrayList<>(999);
        targetList.add(person);
        CollectionUtils.addAll(targetList, sourceArray);
        personDb.setPersonArray(targetList.toArray(Person[]::new));
    }


    public PersonDb getDb() {

        return personDb;
    }
}
