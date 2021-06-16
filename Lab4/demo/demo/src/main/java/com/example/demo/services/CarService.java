package com.example.demo.services;

import com.example.demo.contract.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {


    public List<Car> db = new ArrayList<Car>();

    public List<Car> getAll() {
        return db;
    }

    public Car saveCar(Car car) {
        Car existingCar = db.stream().filter(car1 -> car1.getModel().equals(car.getModel()))
                .findFirst()
                .orElse(null);
        if (existingCar == null) {
            car.setID(db.size() + 1);
            db.add(car);
            return null;
        } else {
            return existingCar;
        }
    }

    public Optional<Car> getCar(int index) {
        return db.stream().filter(c -> c.getID() == index).findAny();
    }

    public Car replace(int index, Car car) {
        Optional<Car> any = db.stream().filter(c -> c.getID() == index).findAny();
        if (any.isPresent()) {
            car.setID(index);
            db.set(db.indexOf(any.get()), car);
            return car;
        } else {
            return null;
        }
    }

    public Car deleteCar(int id) {
        Optional<Car> any = db.stream().filter(c -> c.getID() == id).findAny();
        return any.map(car -> db.remove(db.indexOf(car))).orElse(null);
    }
}
