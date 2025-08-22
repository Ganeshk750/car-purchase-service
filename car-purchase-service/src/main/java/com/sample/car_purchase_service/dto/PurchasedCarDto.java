package com.sample.car_purchase_service.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PurchasedCarDto {
    private Long id;
    private LocalDate purchaseDate;
    private double purchasePrice;
    private String paymentMethod; // e.g., Cash, Bank Transfer, UPI
    private boolean isDelivered; // true if car has been handed over
    private Long buyerId;
    private Long sellerId;
    private Long carId;
}
