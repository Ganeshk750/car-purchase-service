package com.sample.car_purchase_service.controller;

import com.sample.car_purchase_service.dto.PurchasedCarDto;
import com.sample.car_purchase_service.service.PurchasedCarService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/purchased-car")
@AllArgsConstructor
public class PurchasedCarController {
    private static final Logger logger = LoggerFactory.getLogger(PurchasedCarController.class);
    @Autowired
    private final PurchasedCarService service;
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        logger.info("Fetching all purchased cars");
        List<PurchasedCarDto> all = service.getAll();
        logger.info("Total cars fetched: {}", all.size());
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/getOne={id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        logger.info("Fetching  purchased car with id {}", id);
        PurchasedCarDto purchasedCarDto = service.getbyId(id);
        logger.info("Cars fetched: {}", purchasedCarDto);
        return new ResponseEntity<>(purchasedCarDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody PurchasedCarDto purchasedCarDto){
        logger.info("Adding new  purchased car:{}", purchasedCarDto);
        PurchasedCarDto purchasedCarDto1 = service.add(purchasedCarDto);
        logger.info("Cars added successfully: {}", purchasedCarDto);
        return new ResponseEntity<>(purchasedCarDto1, HttpStatus.OK);
    }

    @PutMapping("/update={id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PurchasedCarDto purchasedCarDto){
        logger.info("Updating purchased car with id:{}", id);
        PurchasedCarDto purchasedCarDto1 = service.updateById(id, purchasedCarDto);
        logger.info("Car updated successfully: {}", purchasedCarDto);
        return new ResponseEntity<>(purchasedCarDto1, HttpStatus.OK);
    }

    @DeleteMapping("/delete={id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        logger.info("Deleting purchased car with id:{}", id);
        service.deleteById(id);
        logger.debug("Car deleted succefully with id:{}", id);
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }

}
