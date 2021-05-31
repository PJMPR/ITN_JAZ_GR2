package com.example.demo.controllers;

import com.example.demo.contract.Car;
import com.example.demo.services.CarsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarsController {

	private final CarsService service;

	public CarsController(CarsService service) {
		this.service = service;
	}

	@GetMapping()
	public ResponseEntity<List<Car>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@PostMapping()
	public ResponseEntity saveCar(@RequestBody Car car) {

		int id = service.saveCar(car);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("{id}")
	public ResponseEntity<Car> getById(@PathVariable("id") int id) {
		Car result = service.getById(id);
		if (result == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(result);
	}

	@PutMapping("{id}")
	public ResponseEntity updateCar(@PathVariable int id, @RequestBody Car car) {
		Car result = service.update(id, car);
		if (result == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity deleteCar(@PathVariable("id") int id) {
		Car result = service.delete(id);
		if (result == null) return ResponseEntity.notFound().build();
		return ResponseEntity.noContent().build();
	}
}
