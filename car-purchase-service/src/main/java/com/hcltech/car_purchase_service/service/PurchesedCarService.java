package com.hcltech.car_purchase_service.service;

import com.hcltech.car_purchase_service.dto.PurchasedCarDto;
import com.hcltech.car_purchase_service.entity.PurchasedCar;

import java.util.List;

public interface PurchesedCarService {
    List<PurchasedCarDto> getAll();

    PurchasedCarDto add(PurchasedCarDto purchasedCarDto);

    PurchasedCarDto getbyId(Long id);

    PurchasedCarDto updateById(Long id, PurchasedCarDto purchasedCarDto);

    String deleteById(Long id);
}
