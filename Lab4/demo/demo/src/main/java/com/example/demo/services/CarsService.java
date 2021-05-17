package com.example.demo.services;

import com.example.demo.contract.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class CarsService {

    public List<Car> db = new ArrayList<>();

    public List<Car> getAll() {
        return db;
    }

    public int saveCar(Car car) {

        OptionalInt maxId = db.stream().mapToInt(c -> c.getId()).max();
        if (maxId.isPresent())
            car.setId(maxId.getAsInt() + 1);
        else car.setId(1);
        db.add(car);
        return car.getId();
    }

    public Car getById(int id) {
        Car result = getCarById(id);
        return result;
    }

    public Car update(int id, Car car) {
        Car result = getCarById(id);
        if (result == null) return null;
        result.setHasAccidents(car.isHasAccidents());
        result.setMilleage(car.getMilleage());
        result.setModel(car.getModel());
        result.setPrice(car.getPrice());
        result.setRegistrationNumber(car.getRegistrationNumber());
        return result;
    }

    private Car getCarById(int id2) {
        Optional<Car> result = db.stream().filter(c -> c.getId() == id2).findFirst();
        if (result.isEmpty()) return null;
        return result.get();
    }

    public Car deleteCar(int id) {
        Car result = getCarById(id);
        if (result==null) return null;
        db.remove(result);
        return result;
    }
}