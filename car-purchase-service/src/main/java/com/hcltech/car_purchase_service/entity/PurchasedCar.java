package com.hcltech.car_purchase_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "purchased_car")
public class PurchasedCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String car;
    private String buyer;
    private String seller;
    private LocalDate purchaseDate;
    private double purchasePrice;
    private String paymentMethod; // e.g., Cash, Bank Transfer, UPI
    private boolean isDelivered; // true if car has been handed over
    private String deliveryAddress;
}


