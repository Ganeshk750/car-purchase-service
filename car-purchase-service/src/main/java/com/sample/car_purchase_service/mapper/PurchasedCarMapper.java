package com.sample.car_purchase_service.mapper;

import com.sample.car_purchase_service.dto.PurchasedCarDto;
import com.sample.car_purchase_service.entity.PurchasedCar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchasedCarMapper {
    @Mapping(target = "seller.id", source = "sellerId")
    @Mapping(target = "car.id", source = "carId")
    @Mapping(target = "buyer.id", source = "buyerId")
    PurchasedCar toEntity(PurchasedCarDto purchasedCarDto);
    @Mapping(target = "sellerId", source = "seller.id")
    @Mapping(target = "carId", source = "car.id")
    @Mapping(target = "buyerId", source = "buyer.id")
    PurchasedCarDto toDto(PurchasedCar purchasedCar);
    List<PurchasedCarDto> toDtoList(List<PurchasedCar> PurchasedCar);
}
