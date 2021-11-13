package com.actuator.controller;

import com.actuator.beans.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    protected Car car;

    @GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCarName() {
        return car.getCarName() + car.getCarNo();
    }

}
