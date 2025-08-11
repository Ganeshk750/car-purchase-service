package com.hcltech.car_purchase_service.controller;
import com.hcltech.car_purchase_service.dto.CarDto;
import com.hcltech.car_purchase_service.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class CarController {
    @Autowired
    private final CarService service;
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        List<CarDto> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("getOne/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        CarDto car = service.getById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CarDto carDto){
        CarDto carDto1 = service.add(carDto);
        return new ResponseEntity<>(carDto1, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CarDto carDto){
        CarDto carDto1 = service.updateById(id, carDto);
        return new ResponseEntity<>(carDto1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }

}
