package com.example.demo.services;

import com.example.demo.contract.Car;
import com.example.demo.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsDataService {

    final private CarRepository repository;


    public CarsDataService(CarRepository repository) {
        this.repository = repository;
    }

    public int saveCar(Car car){
        Car result = repository.save(car);
        return result.getID();
    }

    public List<Car> getAll(String model){
        if(model == null || model.equals(""))
            return repository.findAll();
        return repository.findByModel(model);
    }

    public Car getById(int id){
        Car car = repository.findById(id).orElse(null);
        return car;
    }

    public Car update(int id, Car c){
        Car car = getById(id);
        if(car==null)return null;
        car.setRegistrationNumber(c.getRegistrationNumber());
        car.setPrice(c.getPrice());
        car.setModel(c.getModel());
        car.setMilleage(c.getMilleage());
        car.setHasAccidents(c.isHasAccidents());
        repository.save(car);
        return car;

    }

    public Car delete(int id){
        Car car = getById(id);
        if(car==null)return null;
        repository.delete(car);
        return car;
    }
}
