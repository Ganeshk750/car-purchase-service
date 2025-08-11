package com.hcltech.car_purchase_service.repository;

import com.hcltech.car_purchase_service.entity.Person;
import com.hcltech.car_purchase_service.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByRole(Role role);
}
