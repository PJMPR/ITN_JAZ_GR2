package com.example.demo.services;

import com.example.demo.contract.Car;
import com.example.demo.contract.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class CarsService {

    public List<Car> db = new ArrayList<>();

    public List<Car> getAll()
    {
        return db;
    }

    public int saveCar(Car car)
    {
        OptionalInt maxId = db.stream().mapToInt(p -> p.getID()).max();
        if (maxId.isPresent())
            car.setID(maxId.getAsInt() + 1);
        else car.setID(1);
        db.add(car);
        return car.getID();
    }

    public Car getById(int id) {
        Car result = getCarById(id);
        return result;
    }

    public Car update(int id, Car car)
    {
        Car result = getCarById(id);
        if (result == null) return null;
        result.setModel(car.getModel());
        result.setRegistrationNumber(car.getRegistrationNumber());
        result.setMilleage(car.getMilleage());
        result.setHasAccidents(car.isHasAccidents());
        result.setPrice(car.getPrice());
        return result;
    }

    private Car getCarById(int id2)
    {
        Optional<Car> result = db.stream().filter(p -> p.getID() == id2).findFirst();
        if (result.isEmpty()) return null;
        return result.get();
    }

    public Car deleteCar(int id)
    {
        Car result = getCarById(id);
        if (result == null) return null;
        db.remove(result);
        return result;
    }
}
