package com.hcltech.car_purchase_service.service_test;

import com.hcltech.car_purchase_service.dto.CarDto;
import com.hcltech.car_purchase_service.entity.Car;
import com.hcltech.car_purchase_service.mapper.CarMapper;
import com.hcltech.car_purchase_service.repository.CarRepository;
import com.hcltech.car_purchase_service.service.impl.CarServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
        @Mock
        CarMapper carMapper;
        @Mock
        CarRepository repository;
        @InjectMocks
        CarServiceImpl carService;


    @Test
    void testGetAllCars() {
        List<Car> carList = List.of(new Car(), new Car());
        List<CarDto> dtoList = List.of(new CarDto(), new CarDto());

        Mockito.when(repository.findAll()).thenReturn(carList);
        Mockito.when(carMapper.toDtoList(carList)).thenReturn(dtoList);

        List<CarDto> result = carService.getAll();

        Assertions.assertEquals(2, result.size());
        Mockito.verify(repository).findAll();
        Mockito.verify(carMapper).toDtoList(carList);
    }

    @Test
    void testGetCarById() {
        Long id = 1L;
        Car car = new Car();
        car.setId(id);
        car.setModel("Model S");

        CarDto dto = new CarDto();
        dto.setId(id);
        dto.setModel("Model S");

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(car));
        Mockito.when(carMapper.toDto(car)).thenReturn(dto);

        CarDto result = carService.getById(id);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Model S", result.getModel());
    }



    @Test
    void testAddCar() {
        CarDto dto = new CarDto();
        dto.setModel("Model X");

        Car car = new Car();
        car.setModel("Model X");

        Mockito.when(carMapper.toEntity(dto)).thenReturn(car);
        Mockito.when(repository.save(car)).thenReturn(car);
        Mockito.when(carMapper.toDto(car)).thenReturn(dto);

        CarDto result = carService.add(dto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Model X", result.getModel());
    }



    @Test
    void testUpdateCarById() {
        Long id = 1L;

        Car existingCar = new Car();
        existingCar.setId(id);
        existingCar.setModel("Old Model");

        CarDto updatedDto = new CarDto();
        updatedDto.setId(id);
        updatedDto.setModel("New Model");

        Car updatedEntity = new Car();
        updatedEntity.setId(id);
        updatedEntity.setModel("New Model");

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(existingCar));
        Mockito.when(carMapper.toEntity(updatedDto)).thenReturn(updatedEntity);
        Mockito.when(repository.save(updatedEntity)).thenReturn(updatedEntity);
        Mockito.when(carMapper.toDto(updatedEntity)).thenReturn(updatedDto);

        CarDto result = carService.updateById(id, updatedDto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("New Model", result.getModel());
    }


    @Test
    void testDeleteCarById() {
        Long id = 1L;
        Car car = new Car();
        car.setId(id);

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(car));
        Mockito.doNothing().when(repository).deleteById(id);

        String result = carService.deleteById(id);

        Assertions.assertEquals("Deleted Successfully", result);
        Mockito.verify(repository).deleteById(id);
    }



}
