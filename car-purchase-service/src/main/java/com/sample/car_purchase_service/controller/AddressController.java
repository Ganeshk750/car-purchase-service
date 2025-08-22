package com.sample.car_purchase_service.controller;

import com.sample.car_purchase_service.dto.AddressDto;
import com.sample.car_purchase_service.service.AddressService;
import lombok.AllArgsConstructor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {
    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);
    @Autowired
    private  final AddressService service;

    @GetMapping("/all")
        public ResponseEntity<?>getAll(){return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
        }

    @GetMapping("/get={id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        logger.info("GET request received for address ID: {}", id);
        return new ResponseEntity<>( service.getById(id), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AddressDto addressDto){
        logger.info("POST request received to add address : {}", addressDto);
        return new ResponseEntity<>( service.add(addressDto), HttpStatus.OK);
    }


    @PutMapping("/update={id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody AddressDto addressDto){
        logger.info("PUT request received to update  addresses ID: {} with data: {}", id, addressDto);
        return new ResponseEntity<>( service.updateById(id,addressDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete={id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        logger.info("DELETE request received for addresses ID: {}", id);
        return new ResponseEntity<>( service.deleteById(id), HttpStatus.OK);
    }
}
