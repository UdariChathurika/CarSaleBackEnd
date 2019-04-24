package com.example.project.CarSale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.CarSale.exception.ServiceException;
import com.example.project.CarSale.model.Car;
import com.example.project.CarSale.services.CarService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class CarControllerImpl implements CarController{

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public List<Car> fetchAllCars() {
        return carService.findAllCars();
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        try {
            carService.saveCar(carService.validateRequiredFields(car));
            return ResponseEntity.ok(car);
        }catch(ServiceException se) {
            System.out.println("Exception cause: "+se.getMessage());
            throw new ServiceException("Service Exception",se);
        }
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public Car getCarById(@PathVariable Integer id) {
        return carService.findById(id);
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Car> updateCustomer(@PathVariable Integer id, @RequestBody Car car) {
        return carService.updateCar(id,car);
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delelteCar(@PathVariable Integer id) {
        return carService.deleteCar(id);
    }

}