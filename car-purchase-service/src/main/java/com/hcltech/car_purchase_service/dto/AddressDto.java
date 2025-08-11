package com.hcltech.car_purchase_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressDto {
        private Long id;
        private String street;
        private String city;
        private String state;
        private String postalCode;
        private String country;
        private Long personId; // Reference to the Person entity


}
