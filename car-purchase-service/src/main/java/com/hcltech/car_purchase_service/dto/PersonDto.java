package com.hcltech.car_purchase_service.dto;

import com.hcltech.car_purchase_service.entity.Address;
import com.hcltech.car_purchase_service.entity.PurchasedCar;
import com.hcltech.car_purchase_service.enums.Role;
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
    private List<AddressDto> addressDtoList;
    private List<PurchasedCarDto> purchasedCarsAsBuyer;
    private List<PurchasedCarDto> purchasedCarsAsSeller;
}
