package com.example.project.CarSale.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.project.CarSale.model.Car;

public interface CarController {

    public List<Car> fetchAllCars();

    public ResponseEntity<Car> saveCar(Car car);

    public Car getCarById(Integer id);

    public ResponseEntity<Car> updateCustomer(Integer id, Car car);

    public ResponseEntity<String> delelteCar(Integer id);
}
