package com.sample.car_purchase_service.mapper;

import com.sample.car_purchase_service.dto.CarDto;
import com.sample.car_purchase_service.entity.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PurchasedCarMapper.class})
public interface CarMapper {
    Car toEntity(CarDto carDto);
    CarDto toDto(Car car);
    List<CarDto> toDtoList(List<Car> carList);
}