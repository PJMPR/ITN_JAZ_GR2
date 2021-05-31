package com.example.demo.services;

import com.example.demo.contract.Car;
import com.example.demo.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public Car saveCar(Car car) {
        return repository.save(car);
    }

    public Optional<Car> getCar(int index) {
        return  Optional.of(repository.getOne(index));
    }

    public Car replace(int index, Car car) {
        return repository.findAll().set(index,car);
    }

    public Car deleteCar(int id) {
        return repository.findAll().remove(id);
    }
}
