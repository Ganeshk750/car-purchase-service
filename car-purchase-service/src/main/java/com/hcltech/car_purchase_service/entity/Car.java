package com.hcltech.car_purchase_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name ="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Make is required")
    @Size(max = 100)
    private String make;

    @NotBlank(message = "Model is required")
    @Size(max = 100)
    private String model;

    @Min(value = 1886, message = "Manufacture year must be no earlier than 1886")
    @Max(value = 2100, message = "Manufacture year must be no later than 2100")
    private int manufactureYear;

    @NotBlank(message = "Color is required")
    @Size(max = 50)
    private String color;

    @Min(value = 0, message = "Mileage must be non-negative")
    private int mileage;

    @NotBlank(message = "Fuel type is required")
    @Size(max = 50)
    private String fuelType;

    @NotBlank(message = "Transmission type is required")
    @Size(max = 50)
    private String transmission;

    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be non-negative")
    private double price;

    @NotBlank(message = "Location is required")
    @Size(max = 100)
    private String location;

    private boolean isAvailable = false;

    @NotBlank(message = "Description is required")
    @Size(max = 1000)
    private String description;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PurchasedCar purchasedCar;



}
