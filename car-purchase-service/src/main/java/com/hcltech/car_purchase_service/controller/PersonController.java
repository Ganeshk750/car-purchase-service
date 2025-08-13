package com.hcltech.car_purchase_service.controller;

import com.hcltech.car_purchase_service.dto.PersonDto;
import com.hcltech.car_purchase_service.enums.Role;
import com.hcltech.car_purchase_service.service.PersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private final PersonService service;
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        logger.info("GET request received for Fetching for all person");
        List<PersonDto> all = service.getAll();
        logger.info("Fetched {} persons from database", all.size());
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?>getOne(@PathVariable Long id){
        logger.info("GET request received for Person ID: {}", id);
        PersonDto personDto = service.getOne(id);
        return new ResponseEntity<>(personDto,HttpStatus.OK);
    }
    @GetMapping("/getBy/{role}")
    public ResponseEntity<?> byrole(@PathVariable Role role){
        logger.info("GET request received for persons with role: {}", role);
        List<PersonDto> withRole = service.withRole(role);
        return new ResponseEntity<>(withRole,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody PersonDto personDto){
        logger.info("POST request received to add new person: {}", personDto);
        System.out.println("add");
        PersonDto add = service.add(personDto);
        logger.info("Person added successfully with ID: {}",personDto);
        return new ResponseEntity<>(add, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody PersonDto personDto){
        logger.info("PUT request received to update person ID: {} with data: {}", id,personDto);
        PersonDto update = service.update(id, personDto);
        logger.info("Person updated successfully for ID: {}",id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        logger.info("Delete request received for person ID: {}", id);
        service.delete(id);
        logger.info("Person deleted successfully for ID: {}", id);
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}
