package com.hcltech.car_purchase_service.service.impl;

import com.hcltech.car_purchase_service.dto.CarDto;
import com.hcltech.car_purchase_service.entity.Car;
import com.hcltech.car_purchase_service.mapper.CarMapper;
import com.hcltech.car_purchase_service.repository.CarRepository;
import com.hcltech.car_purchase_service.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);
    @Autowired
    private final CarRepository repository;
    @Autowired
    private final CarMapper carMapper;
    public CarServiceImpl(CarMapper carMapper, CarRepository repository) {
        this.carMapper = carMapper;
        this.repository = repository;
    }



    @Override
    public List<CarDto> getAll(){
        logger.info("Fetching all cars");

      List<CarDto> cars = carMapper.toDtoList(repository.findAll());
      logger.info("Total cars found:{}", cars.size());
      return cars;
    }
    @Override
    public CarDto getById(Long id){
        logger.info("Fetching car with ID:{}",id);
        CarDto carDto= carMapper.toDto(repository.findById(id).orElseThrow(() -> {
            logger.error("car not found with ID: {}", id);
            return
                    new OpenApiResourceNotFoundException("No car found with id: "+ id);
        }));
        logger.info("Car fetched successfully with ID:{}",id);
        return carDto;
    }

    @Override
    public CarDto updateById(Long id, CarDto carDto){
        logger.info("Updating car with ID:{}",id);
        Car update = repository.findById(id).orElseThrow(() -> {
            logger.error("Car not found for update with ID:{}", id);
            return
                    new OpenApiResourceNotFoundException("No car found with id: " + id);
        });
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
        logger.info("Deleting car with ID:{}",id);
        if (repository.findById(id).orElseThrow(() -> {
            logger.error("Car not found for delete with ID:{}",id);
            return
                new OpenApiResourceNotFoundException("No car found with id: " + id);
        })!=null) {
            repository.deleteById(id);
            logger.info("Car deleted successfully with ID:{}",id);
            return "Deleted Successfully";
        }else {
            logger.warn("Car not deleted. ID not found:{}",id);
            return "Not deleted";
        }
    }


    @Override
    public List<CarDto> getByModel(String model) {
        return carMapper.toDtoList(repository.findByModel(model));
    }
@Override
public List<CarDto> getByYear(int year) {
        return carMapper.toDtoList(repository.findByManufactureYear(year));
    }
@Override
public List<CarDto> getByPriceRange(double minPrice, double maxPrice) {
        return carMapper.toDtoList(repository.findByPriceBetween(minPrice, maxPrice));
    }

}
