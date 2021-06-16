package com.example.demo.services;

import com.example.demo.contract.AccidentDto;
import com.example.demo.contract.AccidentSummaryDto;
import com.example.demo.contract.CarDto;
import com.example.demo.model.Accident;
import com.example.demo.model.Car;
import com.example.demo.repositories.AccidentRepository;
import com.example.demo.repositories.CarRepository;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarsService {

	private final CarRepository carRepository;
	private final AccidentRepository accidentRepository;
	private final Mapper mapper;

	@Autowired
	public CarsService(CarRepository carRepository, AccidentRepository accidentRepository, Mapper mapper) {
		this.carRepository = carRepository;
		this.accidentRepository = accidentRepository;
		this.mapper = mapper;
	}

	private void setLocationOnAccidents(int carId, List<AccidentSummaryDto> accidents) {
		accidents.stream().forEach(a -> a.setLocation(getUri(carId, a.getId())));

	}

	private String getUri(int carId, int accidentId) {
		return ServletUriComponentsBuilder.fromCurrentContextPath()
				.pathSegment("cars")
				.pathSegment(carId + "")
				.pathSegment("accidents")
				.pathSegment(accidentId + "").build().toUriString();
	}

	public List<CarDto> getAll(String model) {
		List<Car> result;
		if (model == null || model == "")
			result = carRepository.findAll();
		else result = carRepository.findByModel(model);
		List<CarDto> res = result.stream()
				.map(x -> mapper.map(x, CarDto.class))
				.collect(Collectors.toList());
		res.stream().forEach(c -> setLocationOnAccidents(c.getID(), c.getAccidents()));
		return res;
	}

	public int saveCar(Car car) {
		this.carRepository.save(car);
		return car.getID();
	}

	public CarDto getById(int id) {
		Car car = carRepository.findById(id).orElse(null);
		if (car == null) return null;
		CarDto result = mapper.map(car, CarDto.class);
		setLocationOnAccidents(result.getID(), result.getAccidents());
		return result;
	}

	public CarDto update(int id, Car c) {
		Car car = carRepository.findById(id).orElse(null);
		if (car == null) return null;
		car.setHasAccidents(c.isHasAccidents());
		car.setModel(c.getModel());
		car.setMilleage(c.getMilleage());
		car.setPrice(c.getPrice());
		car.setRegistrationNumber(c.getRegistrationNumber());
		carRepository.save(car);
		return mapper.map(car, CarDto.class);
	}

	private Car getCarById(int id2) {
		Optional<Car> result = this.carRepository.findById(id2);
		if (!result.isPresent()) return null;
		return result.get();
	}

	public CarDto deleteCar(int id) {
		Car car = carRepository.findById(id).orElse(null);
		if (car == null) return null;
		carRepository.delete(car);
		return mapper.map(car, CarDto.class);
	}

	public AccidentDto saveAccident(int id, Accident accident) {
		Car car = carRepository.findById(id).orElse(null);
		if (car == null) return null;
		car.getAccidents().add(accident);
		accident.setCar(car);
		carRepository.save(car);
		accidentRepository.save(accident);
		return mapper.map(accident, AccidentDto.class);
	}

	public List<AccidentDto> getAccidents(int id) {
		Car car = carRepository.findById(id).orElse(null);
		if (car == null) return null;
		return car.getAccidents()
				.stream()
				.map(x -> mapper.map(x, AccidentDto.class))
				.collect(Collectors.toList());
	}

	public AccidentDto deleteAccident(int carId, int accidentId) {
		Car car = carRepository.findById(carId).orElse(null);
		if (car == null) return null;
		Accident accidentToDelete = car
				.getAccidents()
				.stream()
				.filter(a -> a.getId() == accidentId)
				.findFirst()
				.orElse(null);
		if (accidentToDelete == null) return null;
		car.getAccidents().remove(accidentToDelete);
		accidentRepository.delete(accidentToDelete);
		return mapper.map(accidentToDelete, AccidentDto.class);
	}


	public AccidentDto updateAccident(int carId, int accidentId, AccidentDto accident) {
		Car car = carRepository.findById(carId).orElse(null);
		if (car == null) return null;
		Accident accidentToUpdate = accidentRepository.findById(accidentId).orElse(null);
		if (accidentToUpdate == null) return null;
		mapper.map(accident, accidentToUpdate);
		accidentToUpdate.setId(accidentId);
		accidentRepository.save(accidentToUpdate);
		return accident;
	}

	public AccidentDto getAccidentById(int carId, int accidentId) {
		Car car = carRepository.findById(carId).orElse(null);
		if (car == null) return null;
		Accident accidentToGet = accidentRepository.findById(accidentId).orElse(null);
		if (accidentToGet == null) return null;
		AccidentDto result = mapper.map(accidentToGet, AccidentDto.class);
		return result;
	}
}
