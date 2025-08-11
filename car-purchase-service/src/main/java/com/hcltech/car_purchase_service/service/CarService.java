package com.hcltech.car_purchase_service.service;

import com.hcltech.car_purchase_service.dto.CarDto;
import com.hcltech.car_purchase_service.entity.Car;

import java.util.List;

public interface CarService {
    List<CarDto> getAll();

    CarDto getById(Long id);

    CarDto updateById(Long id, CarDto carDto);

    CarDto add(CarDto carDto);

    String deleteById(Long id);
}
