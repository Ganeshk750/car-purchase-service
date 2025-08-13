package com.hcltech.car_purchase_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Street is required")
    @Size(max = 255, message = "Street name must be less than 255 characters")
    private String street;

    @NotBlank(message = "State is required")
    @Size(max = 100, message = "City name must be less than 100 characters")
    private String city;

    @NotBlank(message = "Postal code is required")
    @Pattern(regexp = "^[0-9]{5,6}$", message = "Postal code must be 5 or 6 digits")
    private String postalCode;

    @NotBlank(message = "State is required")
    @Size(max = 100, message = "State name must be less than 100 characters")
    private String state;

    @NotBlank(message = "Country is required")
    @Size(max = 100, message = "Country name must be less than 100 characters")
    private String country;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

}
