package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.CarDto;
import com.hcltech.car_purchase_service.entity.Car;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-12T22:47:31+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class CarMappersImpl implements CarMappers {

    @Autowired
    private PurchasedCarMappers purchasedCarMappers;

    @Override
    public Car toEntity(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        Car car = new Car();

        car.setId( carDto.getId() );
        car.setMake( carDto.getMake() );
        car.setModel( carDto.getModel() );
        car.setManufactureYear( carDto.getManufactureYear() );
        car.setColor( carDto.getColor() );
        car.setMileage( carDto.getMileage() );
        car.setFuelType( carDto.getFuelType() );
        car.setTransmission( carDto.getTransmission() );
        car.setPrice( carDto.getPrice() );
        car.setAvailable( carDto.isAvailable() );
        car.setDescription( carDto.getDescription() );
        car.setPurchasedCar( purchasedCarMappers.toEntity( carDto.getPurchasedCar() ) );

        return car;
    }

    @Override
    public CarDto toDto(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

        carDto.setId( car.getId() );
        carDto.setMake( car.getMake() );
        carDto.setModel( car.getModel() );
        carDto.setManufactureYear( car.getManufactureYear() );
        carDto.setColor( car.getColor() );
        carDto.setMileage( car.getMileage() );
        carDto.setFuelType( car.getFuelType() );
        carDto.setTransmission( car.getTransmission() );
        carDto.setPrice( car.getPrice() );
        carDto.setAvailable( car.isAvailable() );
        carDto.setDescription( car.getDescription() );
        carDto.setPurchasedCar( purchasedCarMappers.toDto( car.getPurchasedCar() ) );

        return carDto;
    }

    @Override
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
