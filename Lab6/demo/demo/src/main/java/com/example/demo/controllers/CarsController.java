package com.example.demo.controllers;

import com.example.demo.contract.AccidentDto;
import com.example.demo.contract.CarDto;
import com.example.demo.model.Accident;
import com.example.demo.model.Car;
import com.example.demo.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import java.util.List;

@RestController
@RequestMapping("cars")

public class CarsController {

    private final CarsService carsService;

    @Autowired
    public CarsController(CarsService service) {
        this.carsService = service;
    }

    @GetMapping()
    public ResponseEntity getAll(@RequestParam(value = "model", required = false) String model) {
        return ResponseEntity.ok(carsService.getAll(model));
    }

    @PostMapping()
    public ResponseEntity saveCar(@RequestBody Car car) {
        int id = carsService.saveCar(car);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<CarDto> getById(@PathVariable("id") int id) {
        CarDto result = carsService.getById(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PutMapping("{id}")
    public ResponseEntity updateCar(@PathVariable("id") int id, @RequestBody Car car) {
        CarDto result = carsService.update(id, car);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCar(@PathVariable("id") int id) {
        CarDto result = carsService.deleteCar(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @PostMapping("{id}/accidents")
    public ResponseEntity addAccident(
            @PathVariable("id") int id,
            @RequestBody Accident accident
    ){
        AccidentDto a = carsService.saveAccident(id, accident);
        if(a==null) return ResponseEntity.notFound().build();
        UriComponents uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .pathSegment("car")
                .pathSegment(id+"")
                .pathSegment("accidents")
                .pathSegment(a.getId()+"").build();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/accidents")
    public ResponseEntity getAccident(@PathVariable("id") int id){
        List<AccidentDto> accidents = carsService.getAccidents(id);
        if(accidents==null)return ResponseEntity.notFound().build();
        return ResponseEntity.ok(accidents);
    }

    @GetMapping("{id}/accidents/{accident_id}")
    public ResponseEntity getAccidentById(
            @PathVariable("id") int carId,
            @PathVariable("accident_id") int accidentId
    ){
        AccidentDto accident = carsService.getAccidentById(carId, accidentId);
        if(accident==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(accident);
    }

    @DeleteMapping("{id}/accidents/{accident_id}")
    public ResponseEntity deleteAccident(
            @PathVariable("id") int carId,
            @PathVariable("accident_id") int accidentId
    ){
        AccidentDto accident = carsService.deleteAccident(carId, accidentId);
        if(accident == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/accidents/{accident_id}")
    public ResponseEntity updateAccident(
            @PathVariable("id") int carId,
            @PathVariable("accident_id") int accidentId,
            @RequestBody AccidentDto accident
    ){
        AccidentDto accidentDto = carsService.updateAccident(carId, accidentId, accident);
        if(accidentDto==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }
}