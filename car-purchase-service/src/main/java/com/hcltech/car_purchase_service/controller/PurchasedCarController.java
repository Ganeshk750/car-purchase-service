package com.hcltech.car_purchase_service.controller;

import com.hcltech.car_purchase_service.entity.Person;
import com.hcltech.car_purchase_service.entity.PurchasedCar;
import com.hcltech.car_purchase_service.service.PersonService;
import com.hcltech.car_purchase_service.service.PurchesedCarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/purchased-car")
@AllArgsConstructor
public class PurchasedCarController {
    @Autowired
    private final PurchesedCarService service;
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        List<PurchasedCar> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/getOne={id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        PurchasedCar purchasedCar = service.getbyId(id);
        return new ResponseEntity<>(purchasedCar, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody PurchasedCar purchasedCar){
        PurchasedCar purchasedCar1 = service.add(purchasedCar);
        return new ResponseEntity<>(purchasedCar1, HttpStatus.OK);
    }

    @PutMapping("/update={id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PurchasedCar purchasedCar){
        PurchasedCar purchasedCar1 = service.updateById(id, purchasedCar);
        return new ResponseEntity<>(purchasedCar1, HttpStatus.OK);
    }

    @DeleteMapping("/delete={id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }

}
