package com.hcltech.car_purchase_service.service;

import com.hcltech.car_purchase_service.dto.PurchasedCarDto;

import java.util.List;

public interface PurchasedCarService {
    List<PurchasedCarDto> getAll();

    PurchasedCarDto add(PurchasedCarDto purchasedCarDto);

    PurchasedCarDto getbyId(Long id);

    PurchasedCarDto updateById(Long id, PurchasedCarDto purchasedCarDto);

    String deleteById(Long id);
}
