package com.example.demo.controllers;


import com.example.demo.contract.Car;
import com.example.demo.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("cars")
public class CarsController {

    private final CarsService service;

    public CarsController(CarService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping()
    public ResponseEntity saveCar(@RequestBody Car car) {

        int id = service.saveCar(car);
        return ResponseEntity.created(URI.create("http://localhost:8080/people/"+id)).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") int id) {
        Car result = service.getById(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PutMapping("{id}")1
    public ResponseEntity updateCar(@PathVariable("id") int id, @RequestBody Car car) {
        Car result = service.update(id, car);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCar(@PathVariable("id") int id) {
        Car result = service.deleteCar(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
