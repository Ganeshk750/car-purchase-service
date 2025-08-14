package com.hcltech.car_purchase_service.repository;

import com.hcltech.car_purchase_service.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    List<Car> findByModel(String model);

    List<Car> findByManufactureYear(int year);

    List<Car> findByPriceBetween(double minPrice, double maxPrice);


}
