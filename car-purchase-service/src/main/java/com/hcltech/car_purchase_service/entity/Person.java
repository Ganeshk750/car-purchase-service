package com.hcltech.car_purchase_service.entity;

import com.hcltech.car_purchase_service.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "First name required")
    @Size(max=50,message = "First name cannot be exceed 50 characters")
    private String first_name;
    @NotBlank(message = "Last name required")
    @Size(max=50,message = "Last name cannot be exceed 50 characters")
    private String last_name;
    @NotBlank(message = "Email is required")
    @Email(message = "Email Should be valid")
    private String email;
    @Pattern(regexp = "^[0-9]{10}$",message = "Phone number must be 10 digits")
    private String phone_number;
    @NotNull(message = "Role is required")
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean isVerified;
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Address> addresses;


    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PurchasedCar> purchasedCarsAsBuyer;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PurchasedCar> purchasedCarsAsSeller;




}
