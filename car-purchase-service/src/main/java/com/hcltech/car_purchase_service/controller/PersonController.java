package com.hcltech.car_purchase_service.controller;

import com.hcltech.car_purchase_service.dto.PersonDto;
import com.hcltech.car_purchase_service.service.PersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {
    @Autowired
    private final PersonService service;
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        List<PersonDto> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        PersonDto one = service.getOne(id);
        return new ResponseEntity<>(one, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody PersonDto personDto){
        PersonDto add = service.add(personDto);
        return new ResponseEntity<>(add, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody PersonDto personDto){
//        PersonDto update = service.update(id, personDto);
        return new ResponseEntity<>("update", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

    @GetMapping("/{role}")
    public ResponseEntity<?> withRole(@PathVariable String role){
        return new ResponseEntity<>(service.withRole(role),HttpStatus.OK);

    }
}
