package com.hcltech.car_purchase_service.service;

import com.hcltech.car_purchase_service.entity.PurchasedCar;

import java.util.List;

public interface PurchesedCarService {
    List<PurchasedCar> getAll();

    PurchasedCar add(PurchasedCar purchasedCar);

    PurchasedCar getbyId(Long id);

    PurchasedCar updateById(Long id, PurchasedCar purchasedCar);

    String deleteById(Long id);
}
