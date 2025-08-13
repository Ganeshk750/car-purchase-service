package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.PurchasedCarDto;
import com.hcltech.car_purchase_service.entity.PurchasedCar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchasedCarMappers {
    @Mapping(source = "carId",target = "car.id")
    @Mapping(source = "sellerId",target = "seller.id")
    @Mapping(source = "buyerId",target = "buyer.id")
    PurchasedCar toEntity(PurchasedCarDto purchasedCarDto);
    @Mapping(source = "car.id",target = "carId")
    @Mapping(source = "seller.id",target = "sellerId")
    @Mapping(source = "buyer.id",target = "buyerId")
    PurchasedCarDto toDto(PurchasedCar purchasedCar);
    List<PurchasedCarDto>toDtoList(List<PurchasedCar> purchasedCarList);
}
