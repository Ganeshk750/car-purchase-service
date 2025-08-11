package com.hcltech.car_purchase_service.dto;

import com.hcltech.car_purchase_service.entity.PurchasedCar;
import lombok.Data;

@Data
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
    private String location;       // where the car is available
    private boolean isAvailable=false;   // true if still for sale
    private String description;
}

