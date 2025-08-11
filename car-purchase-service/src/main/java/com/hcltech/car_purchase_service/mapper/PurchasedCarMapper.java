package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.PurchasedCarDto;
import com.hcltech.car_purchase_service.entity.PurchasedCar;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PurchasedCarMapper {
    public PurchasedCar toEntity(PurchasedCarDto dto){
        PurchasedCar purchasedCar = new PurchasedCar();
        purchasedCar.setPurchaseDate(dto.getPurchaseDate());
        purchasedCar.setPurchasePrice(dto.getPurchasePrice());
        purchasedCar.setPaymentMethod(dto.getPaymentMethod());
        purchasedCar.setDelivered(dto.isDelivered());
        purchasedCar.setBuyer(dto.getBuyer());
        purchasedCar.setSeller(dto.getSeller());
        purchasedCar.setCar(dto.getCar());
        purchasedCar.setDeliveryAddress(dto.getDeliveryAddress());
        return purchasedCar;
    }

    public PurchasedCarDto toDto(PurchasedCar purchasedCar){
        PurchasedCarDto dto = new PurchasedCarDto();
        dto.setId(purchasedCar.getId());
        dto.setPurchaseDate(purchasedCar.getPurchaseDate());
        dto.setPurchasePrice(purchasedCar.getPurchasePrice());
        dto.setPaymentMethod(purchasedCar.getPaymentMethod());
        dto.setDelivered(purchasedCar.isDelivered());
        dto.setBuyer(purchasedCar.getBuyer());
        dto.setSeller(purchasedCar.getSeller());
        dto.setCar(purchasedCar.getCar());
        dto.setDeliveryAddress(purchasedCar.getDeliveryAddress());
        return dto;
    }

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

