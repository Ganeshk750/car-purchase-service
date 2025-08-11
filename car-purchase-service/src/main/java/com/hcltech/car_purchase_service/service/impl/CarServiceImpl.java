package com.hcltech.car_purchase_service.service.impl;

import com.hcltech.car_purchase_service.entity.Car;
import com.hcltech.car_purchase_service.repository.CarRepository;
import com.hcltech.car_purchase_service.service.CarService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    @Autowired
    private final CarRepository repository;

    @Override
    public List<Car> getAll(){
        return repository.findAll();
    }
    @Override
    public Car getById(Long id){
        return repository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("No car found with id: " + id));
    }

    @Override
    public Car updateById(Long id, Car car){
        Car update = repository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("No car found with id: " + id));
        if(update!=null){
            update=car;
            update.setId(id);
            return repository.save(car);
        }else {
            return null;
        }
    }


    @Override
    public Car add(Car car){
        return repository.save(car);
    }

    @Override
    public String deleteById(Long id){
        if (repository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("No car found with id: " + id))!=null) {
            repository.deleteById(id);
            return "Deleted Successfully";
        }else {
            return "Not deleted";
        }
    }
}
