package com.hcltech.car_purchase_service.controller;

import com.hcltech.car_purchase_service.dto.PurchasedCarDto;
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
        List<PurchasedCarDto> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/getOne={id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        PurchasedCarDto purchasedCarDto = service.getbyId(id);
        return new ResponseEntity<>(purchasedCarDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody PurchasedCarDto purchasedCarDto){
        PurchasedCarDto purchasedCarDto1 = service.add(purchasedCarDto);
        return new ResponseEntity<>(purchasedCarDto1, HttpStatus.OK);
    }

    @PutMapping("/update={id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PurchasedCarDto purchasedCarDto){
        PurchasedCarDto purchasedCarDto1 = service.updateById(id, purchasedCarDto);
        return new ResponseEntity<>(purchasedCarDto1, HttpStatus.OK);
    }

    @DeleteMapping("/delete={id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }

}
