package com.hcltech.car_purchase_service.controller;
import com.hcltech.car_purchase_service.dto.CarDto;
import com.hcltech.car_purchase_service.service.CarService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class CarController {
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);
    @Autowired
    private final CarService service;
    @GetMapping("/getAll")
    public ResponseEntity<List<CarDto>> getAll(){
        List<CarDto> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("getOne/{id}")
    public ResponseEntity<CarDto> getOne(@PathVariable Long id){
        logger.info("GET request received for Car ID: {}", id);
        CarDto car = service.getById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CarDto> add(@RequestBody CarDto carDto){
        logger.info("POST request received to add Car: {}", carDto);
        CarDto carDto1 = service.add(carDto);
        return new ResponseEntity<>(carDto1, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> update(@PathVariable Long id, @RequestBody CarDto carDto){
        logger.info("PUT request received to update Car ID: {} with data: {}", id, carDto);
        CarDto carDto1 = service.updateById(id, carDto);
        return new ResponseEntity<>(carDto1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        logger.info("Delete request received for Car ID: {}", id);
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }


    @GetMapping("/model/{model}")
    public ResponseEntity<List<CarDto>> getByModel(@PathVariable String model) {
        logger.info("Fetching cars by model: {}", model);
        return ResponseEntity.ok(service.getByModel(model));
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<CarDto>> getByYear(@PathVariable int year) {
        logger.info("Fetching cars by manufacture year: {}", year);
        return ResponseEntity.ok(service.getByYear(year));
    }

    @GetMapping("/price")
    public ResponseEntity<List<CarDto>> getByPriceRange(@RequestParam double min, @RequestParam double max) {
        logger.info("Fetching cars by price range: {} - {}", min, max);
        return ResponseEntity.ok(service.getByPriceRange(min, max));
    }


}
