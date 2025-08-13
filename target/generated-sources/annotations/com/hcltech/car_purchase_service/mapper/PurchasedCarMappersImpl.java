package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.PurchasedCarDto;
import com.hcltech.car_purchase_service.entity.Car;
import com.hcltech.car_purchase_service.entity.Person;
import com.hcltech.car_purchase_service.entity.PurchasedCar;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-12T22:47:31+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class PurchasedCarMappersImpl implements PurchasedCarMappers {

    @Override
    public PurchasedCar toEntity(PurchasedCarDto purchasedCarDto) {
        if ( purchasedCarDto == null ) {
            return null;
        }

        PurchasedCar purchasedCar = new PurchasedCar();

        purchasedCar.setCar( purchasedCarDtoToCar( purchasedCarDto ) );
        purchasedCar.setSeller( purchasedCarDtoToPerson( purchasedCarDto ) );
        purchasedCar.setBuyer( purchasedCarDtoToPerson1( purchasedCarDto ) );
        purchasedCar.setId( purchasedCarDto.getId() );
        purchasedCar.setPurchaseDate( purchasedCarDto.getPurchaseDate() );
        purchasedCar.setPurchasePrice( purchasedCarDto.getPurchasePrice() );
        purchasedCar.setPaymentMethod( purchasedCarDto.getPaymentMethod() );
        purchasedCar.setDelivered( purchasedCarDto.isDelivered() );

        return purchasedCar;
    }

    @Override
    public PurchasedCarDto toDto(PurchasedCar purchasedCar) {
        if ( purchasedCar == null ) {
            return null;
        }

        PurchasedCarDto purchasedCarDto = new PurchasedCarDto();

        purchasedCarDto.setCarId( purchasedCarCarId( purchasedCar ) );
        purchasedCarDto.setSellerId( purchasedCarSellerId( purchasedCar ) );
        purchasedCarDto.setBuyerId( purchasedCarBuyerId( purchasedCar ) );
        purchasedCarDto.setId( purchasedCar.getId() );
        purchasedCarDto.setPurchaseDate( purchasedCar.getPurchaseDate() );
        purchasedCarDto.setPurchasePrice( purchasedCar.getPurchasePrice() );
        purchasedCarDto.setPaymentMethod( purchasedCar.getPaymentMethod() );
        purchasedCarDto.setDelivered( purchasedCar.isDelivered() );

        return purchasedCarDto;
    }

    @Override
    public List<PurchasedCarDto> toDtoList(List<PurchasedCar> purchasedCarList) {
        if ( purchasedCarList == null ) {
            return null;
        }

        List<PurchasedCarDto> list = new ArrayList<PurchasedCarDto>( purchasedCarList.size() );
        for ( PurchasedCar purchasedCar : purchasedCarList ) {
            list.add( toDto( purchasedCar ) );
        }

        return list;
    }

    protected Car purchasedCarDtoToCar(PurchasedCarDto purchasedCarDto) {
        if ( purchasedCarDto == null ) {
            return null;
        }

        Car car = new Car();

        car.setId( purchasedCarDto.getCarId() );

        return car;
    }

    protected Person purchasedCarDtoToPerson(PurchasedCarDto purchasedCarDto) {
        if ( purchasedCarDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( purchasedCarDto.getSellerId() );

        return person;
    }

    protected Person purchasedCarDtoToPerson1(PurchasedCarDto purchasedCarDto) {
        if ( purchasedCarDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( purchasedCarDto.getBuyerId() );

        return person;
    }

    private Long purchasedCarCarId(PurchasedCar purchasedCar) {
        if ( purchasedCar == null ) {
            return null;
        }
        Car car = purchasedCar.getCar();
        if ( car == null ) {
            return null;
        }
        Long id = car.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long purchasedCarSellerId(PurchasedCar purchasedCar) {
        if ( purchasedCar == null ) {
            return null;
        }
        Person seller = purchasedCar.getSeller();
        if ( seller == null ) {
            return null;
        }
        Long id = seller.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long purchasedCarBuyerId(PurchasedCar purchasedCar) {
        if ( purchasedCar == null ) {
            return null;
        }
        Person buyer = purchasedCar.getBuyer();
        if ( buyer == null ) {
            return null;
        }
        Long id = buyer.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
