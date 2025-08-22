package com.sample.car_purchase_service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class CarDto {
    private Long id;
    private String make;           // e.g., Toyota, Honda
    private String model;// e.g., Corolla, Civic
    private int manufactureYear;              // e.g., 2018
    private String color;
    private int mileage;           // in kilometers
    private String fuelType;       // e.g., Petrol, Diesel, Electric
    private String transmission;   // e.g., Manual, Automatic
    private double price;          // asking price
    private boolean isAvailable=false;   // true if still for sale
    private String description;
    private List<PurchasedCarDto> purchasedCar;

}

