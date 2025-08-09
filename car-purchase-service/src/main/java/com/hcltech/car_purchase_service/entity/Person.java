package com.hcltech.car_purchase_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="user_details")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String address;
    private String phone_number;
    private String role;
    private boolean isVerified;

}
