package com.hcltech.car_purchase_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="cars_details")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;           // e.g., Toyota, Honda
    private String model;          // e.g., Corolla, Civic
    private int year;              // e.g., 2018
    private String color;
    private int mileage;           // in kilometers
    private String fuelType;       // e.g., Petrol, Diesel, Electric
    private String transmission;   // e.g., Manual, Automatic
    private double price;          // asking price
    private String location;       // where the car is available
    private boolean isAvailable;   // true if still for sale

    @Column(length = 1000)
    private String description;



}
