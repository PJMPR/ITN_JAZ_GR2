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

	private final CarsService service;

	@Autowired
	public CarsController(CarsService service) {
		this.service = service;
	}

	@GetMapping()
	public ResponseEntity getAll(@RequestParam(value = "model", required = false) String model) {
		return ResponseEntity.ok(service.getAll(model));
	}

	@PostMapping()
	public ResponseEntity saveCar(@RequestBody Car car) {
		int id = service.saveCar(car);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("{id}")
	public ResponseEntity getById(@PathVariable("id") int id) {
		CarDto result = service.getById(id);
		if (result == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(result);
	}

	@PutMapping("{id}")
	public ResponseEntity updateCar(@PathVariable("id") int id, @RequestBody Car car) {
		CarDto result = service.update(id, car);
		if (result == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity deleteCar(@PathVariable("id") int id) {
		CarDto result = service.deleteCar(id);
		if (result == null) return ResponseEntity.notFound().build();
		return ResponseEntity.noContent().build();
	}

	// /cars/1/accidents
	@PostMapping("{id}/accidents")
	public ResponseEntity addAccident(
			@PathVariable("id") int id,
			@RequestBody Accident accident
	) {
		AccidentDto a = service.saveAccident(id, accident);
		if (a == null) return ResponseEntity.notFound().build();
		UriComponents uri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.pathSegment("cars")
				.pathSegment(id + "")
				.pathSegment("accidents")
				.pathSegment(a.getId() + "").build();
		return ResponseEntity.noContent().build();
	}

	@GetMapping("{id}/accidents")
	public ResponseEntity getAccidents(@PathVariable("id") int id) {
		List<AccidentDto> accidents = service.getAccidents(id);
		if (accidents == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(accidents);
	}

	@GetMapping("{id}/accidents/{accident_id}")
	public ResponseEntity getAccidentById(
			@PathVariable("id") int carId,
			@PathVariable("accident_id") int accidentId
	) {
		AccidentDto accident = service.getAccidentById(carId, accidentId);
		if (accident == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(accident);
	}

	@DeleteMapping("{id}/accidents/{accident_id}")
	public ResponseEntity deleteAccident(
			@PathVariable("id") int carId,
			@PathVariable("accident_id") int accidentId
	) {
		AccidentDto accident = service.deleteAccident(carId, accidentId);
		if (accident == null) return ResponseEntity.notFound().build();
		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}/accidents/{accident_id}")
	public ResponseEntity updateAccident(
			@PathVariable("id") int carId,
			@PathVariable("accident_id") int accidentId,
			@RequestBody AccidentDto accident
	) {
		AccidentDto accidentDto = service.updateAccident(carId, accidentId, accident);
		if (accidentDto == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}
}
