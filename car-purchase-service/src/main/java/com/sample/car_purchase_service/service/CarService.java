package com.sample.car_purchase_service.service;

import com.sample.car_purchase_service.dto.CarDto;

import java.util.List;

public interface CarService {
    List<CarDto> getAll();

    CarDto getById(Long id);

    CarDto updateById(Long id, CarDto carDto);

    CarDto add(CarDto carDto);

    String deleteById(Long id);

    List<CarDto> getByModel(String model);

    List<CarDto> getByYear(int year);

    List<CarDto> getByPriceRange(double minPrice, double maxPrice);
}
