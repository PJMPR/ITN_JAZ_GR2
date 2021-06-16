package com.example.demo.controllers;

import com.example.demo.contract.Car;
import com.example.demo.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping()
    public ResponseEntity savePerson(@RequestBody Car car) {
        Car addedCar = carService.saveCar(car);
        return addedCar == null ? ResponseEntity.noContent().build() :
                ResponseEntity.created(URI.create("http://localhost:8080/cars/" + addedCar.getModel())).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") int index) {
        Optional<Car> result = carService.getCar(index);
        if (result.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result.get());
    }

    @PutMapping("{id}")
    public ResponseEntity updatePerson(@PathVariable("id") int index, @RequestBody Car car) {
        Car result = carService.replace(index, car);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(car);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePerson(@PathVariable("id") int id) {
        Car result = carService.deleteCar(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

}
