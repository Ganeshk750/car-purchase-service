package com.hcltech.car_purchase_service.repository;

import com.hcltech.car_purchase_service.entity.PurchasedCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasedCerRepository extends JpaRepository<PurchasedCar,Long> {
}
