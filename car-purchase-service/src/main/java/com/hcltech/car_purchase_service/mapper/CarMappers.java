package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.CarDto;
import com.hcltech.car_purchase_service.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PurchasedCarMappers.class})
public interface CarMappers {
    Car toEntity(CarDto carDto);
    CarDto toDto(Car car);
    List<CarDto> toDtoList(List<Car> carList);
}
