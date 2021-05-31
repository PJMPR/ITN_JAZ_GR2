package com.example.demo.services;

import com.example.demo.contract.Car;
import com.example.demo.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {

    private final CarRepository carRepository;

    @Autowired
    public CarsService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAll() {
        return this.carRepository.findAll();
    }

    public int saveCar(Car car) {
        this.carRepository.save(car);
        return car.getId();
    }

    public Car getById(int id) {
        Car result = getCarById(id);
        return result;
    }

    public Car update(int id, Car car) {
        Car result = getCarById(id);
        if (result == null) return null;
        car.setID(id);
        this.carRepository.save(car);
        return result;
    }

    private Car getCarById(int id2) {
        Optional<Car> result = this.carRepository.findById(id2);
        if (!result.isPresent()) return null;
        return result.get();
    }

    public Car deleteCar(int id) {
        Car result = getCarById(id);
        if (result == null) return null;
        this.carRepository.delete(result);
        return result;

    }
}