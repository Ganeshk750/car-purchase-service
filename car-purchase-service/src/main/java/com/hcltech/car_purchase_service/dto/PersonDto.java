package com.hcltech.car_purchase_service.dto;

import com.hcltech.car_purchase_service.enums.Role;
import lombok.Data;

@Data
public class PersonDto {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String address;
    private String phone_number;
    private Role role;
    private boolean isVerified;
}
