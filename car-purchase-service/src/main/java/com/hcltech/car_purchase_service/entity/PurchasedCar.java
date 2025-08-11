package com.hcltech.car_purchase_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "purchased_car")
public class PurchasedCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Purchase date is required")
    private LocalDate purchaseDate;

    @DecimalMin(value = "0.0", inclusive = true, message = "Purchase price must be non-negative")
    private double purchasePrice;

    @NotBlank(message = "Payment method is required")
    @Size(max = 50)
    private String paymentMethod; // e.g., Cash, Bank Transfer, UPI
    private boolean isDelivered;
    private String  buyer;
    private String seller;
    private String car;
    private String deliveryAddress;



}


