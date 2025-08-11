package com.hcltech.car_purchase_service.dto;

import com.hcltech.car_purchase_service.entity.Address;
import com.hcltech.car_purchase_service.entity.Car;
import com.hcltech.car_purchase_service.entity.Person;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PurchasedCarDto {
    private Long id;
    private LocalDate purchaseDate;
    private double purchasePrice;
    private String paymentMethod; // e.g., Cash, Bank Transfer, UPI
    private boolean isDelivered; // true if car has been handed over
    private Person buyer;
    private Person seller;
    private Car car;
    private Address deliveryAddress;
}
