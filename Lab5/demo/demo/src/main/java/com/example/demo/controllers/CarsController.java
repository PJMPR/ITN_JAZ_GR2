package com.example.demo.controllers;

import com.example.demo.contract.Car;
import com.example.demo.services.CarsDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarsController {

    private final CarsDataService dataService;

    public CarsController(CarsDataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping()
    public ResponseEntity<List<Car>> getAll(@RequestParam(value = "name", required = false) String name) {
        return ResponseEntity.ok(dataService.getAll(name));
    }

    @PostMapping()
    public ResponseEntity saveCar(@RequestBody Car car){

        int id = dataService.saveCar(car);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") int id){
        Car result = dataService.getById(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PutMapping("{id}")
    public ResponseEntity updateCar(@PathVariable int id, @RequestBody Car car){
        Car result = dataService.update(id, car);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCar(@PathVariable("id") int id){
        Car result = dataService.delete(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
