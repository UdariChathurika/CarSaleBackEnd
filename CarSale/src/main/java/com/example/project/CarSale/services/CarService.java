package com.example.project.CarSale.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.project.CarSale.model.Car;

public interface CarService {

    Car validateRequiredFields(Car car);

    List<Car> findAllCars();

    Car saveCar(Car car);

    public ResponseEntity<Car> updateCar(Integer id, Car car);

    Car findById(Integer id);

    ResponseEntity<String> deleteCar(Integer id);
}
