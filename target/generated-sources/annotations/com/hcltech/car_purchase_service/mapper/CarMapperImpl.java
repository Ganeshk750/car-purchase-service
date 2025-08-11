package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.CarDto;
import com.hcltech.car_purchase_service.entity.Car;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-11T17:52:31+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public Car toEntity(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        Car car = new Car();

        return car;
    }

    @Override
    public CarDto toDto(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

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
