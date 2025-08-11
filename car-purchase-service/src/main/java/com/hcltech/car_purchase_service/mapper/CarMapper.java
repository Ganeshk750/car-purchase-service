package com.hcltech.car_purchase_service.mapper;


import com.hcltech.car_purchase_service.dto.CarDto;
import com.hcltech.car_purchase_service.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarMapper {
    @Autowired
    private AddressMapper addressMapper;
    public Car toEntity(CarDto dto){
        Car car = new Car();
        car.setId(dto.getId());
        car.setMake(dto.getMake());
        car.setModel(dto.getModel());
        car.setManufactureYear(dto.getManufactureYear());
        car.setColor(dto.getColor());
        car.setFuelType(dto.getFuelType());
        car.setMileage(dto.getMileage());
        car.setTransmission(dto.getTransmission());
        car.setPrice(dto.getPrice());
        car.setAvailable(dto.isAvailable());
        car.setDescription(dto.getDescription());
        car.setLocation(dto.getLocation());
        return car;
    }

    public CarDto toDto(Car car){
        CarDto dto = new CarDto();
        dto.setId(car.getId());
        dto.setMake(car.getMake());
        dto.setModel(car.getModel());
        dto.setManufactureYear(car.getManufactureYear());
        dto.setColor(car.getColor());
        dto.setFuelType(car.getFuelType());
        dto.setMileage(car.getMileage());
        dto.setTransmission(car.getTransmission());
        dto.setPrice(car.getPrice());
        dto.setAvailable(car.isAvailable());
        dto.setDescription(car.getDescription());
        dto.setLocation(car.getLocation());
        return dto;
    }

    public List<CarDto> toDtoList(List<Car> carList) {
        if ( carList == null ) {
            return null;
        }

        List<CarDto> list = new ArrayList<CarDto>( carList.size() );
        for ( Car car : carList ) {
            list.add( toDto( car ) );
        }

        return list;
    }

}
