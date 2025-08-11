package com.hcltech.car_purchase_service.controller;

import com.hcltech.car_purchase_service.entity.Address;
import com.hcltech.car_purchase_service.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {
    @Autowired
    private  final AddressService service;

    @GetMapping("/get={id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>( service.getById(id), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Address address){
        return new ResponseEntity<>( service.add(address), HttpStatus.OK);
    }


    @PutMapping("/update={id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Address address){
        return new ResponseEntity<>( service.updateById(id,address), HttpStatus.OK);
    }

    @DeleteMapping("/delete={id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return new ResponseEntity<>( service.deleteById(id), HttpStatus.OK);
    }
}
