package com.example.demo.repositories;

import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer > {

    List<Car> findByModel(String name);

}
