package com.hcltech.car_purchase_service.dto;

import com.hcltech.car_purchase_service.entity.Person;
import com.hcltech.car_purchase_service.entity.PurchasedCar;
import lombok.Data;

@Data
public class AddressDto {
        private Long id;
        private String street;
        private String city;
        private String state;
        private String postalCode;
        private String country;
        private Long personId;
}
