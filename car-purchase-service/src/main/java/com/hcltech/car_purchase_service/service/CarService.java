package com.hcltech.car_purchase_service.service;

import com.hcltech.car_purchase_service.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    Car getById(Long id);

    Car updateById(Long id, Car car);

    Car add(Car car);

    String deleteById(Long id);
}
