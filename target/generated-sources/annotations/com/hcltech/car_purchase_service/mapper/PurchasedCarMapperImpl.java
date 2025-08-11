package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.PurchasedCarDto;
import com.hcltech.car_purchase_service.entity.PurchasedCar;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-11T17:52:32+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class PurchasedCarMapperImpl implements PurchasedCarMapper {

    @Override
    public PurchasedCar toEntity(PurchasedCarDto purchasedCarDto) {
        if ( purchasedCarDto == null ) {
            return null;
        }

        PurchasedCar purchasedCar = new PurchasedCar();

        return purchasedCar;
    }

    @Override
    public PurchasedCarDto toDto(PurchasedCar purchasedCar) {
        if ( purchasedCar == null ) {
            return null;
        }

        PurchasedCarDto purchasedCarDto = new PurchasedCarDto();

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
}
