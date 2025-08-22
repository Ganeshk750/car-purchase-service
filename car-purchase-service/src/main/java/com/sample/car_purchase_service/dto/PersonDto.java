package com.sample.car_purchase_service.dto;

import com.sample.car_purchase_service.enums.Role;
import lombok.Data;

import java.util.List;

@Data
public class PersonDto {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private Role role;
    private boolean isVerified;
    private List<AddressDto> addresses;
    private List<PurchasedCarDto> soldCars;
    private List<PurchasedCarDto> purchasedCars;
}
