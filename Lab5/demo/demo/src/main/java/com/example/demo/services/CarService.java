package com.example.demo.services;

import com.example.demo.contract.Car;
import com.example.demo.contract.Person;
import com.example.demo.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class CarService {

    private final CarRepository repository;

    @Autowired
    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public List<Car> getAll() {
        return this.repository.findAll();
    }

    public int saveCar(Car car) {
        this.repository.save(car);
        return car.getId();
    }

    public Car getById(int id) {
        Car result = getCarById(id);
        return result;
    }

    public Car update(int id, Car car) {
        Car result = getCarById(id);
        if (result == null) return null;
        car.setId(id);
        this.repository.save(car);
        return result;
    }

    private Car getCarById(int id2) {
        Optional<Car> result = this.repository.findById(id2);
        if (!result.isPresent()) return null;
        return result.get();
    }

    public Car deleteCar(int id) {
        Car result = getCarById(id);
        if (result == null) return null;
        this.repository.delete(result);
        return result;

    }
}
