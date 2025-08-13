package com.hcltech.car_purchase_service.service.impl;

import com.hcltech.car_purchase_service.dto.CarDto;
import com.hcltech.car_purchase_service.entity.Car;
import com.hcltech.car_purchase_service.mapper.CarMappers;
import com.hcltech.car_purchase_service.repository.CarRepository;
import com.hcltech.car_purchase_service.service.CarService;
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
    @Autowired
    private CarMappers carMapper;

    @Override
    public List<CarDto> getAll(){
        return carMapper.toDtoList(repository.findAll());
    }
    @Override
    public CarDto getById(Long id){
        return carMapper.toDto(repository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("No car found with id: " + id)));
    }

    @Override
    public CarDto updateById(Long id, CarDto carDto){
        Car update = repository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("No car found with id: " + id));
        if(update!=null){
            update=carMapper.toEntity(carDto);
            update.setId(id);
            return carMapper.toDto(repository.save(update));
        }else {
            return null;
        }
    }


    @Override
    public CarDto add(CarDto carDto){
        return carMapper.toDto(repository.save(carMapper.toEntity(carDto)));
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
