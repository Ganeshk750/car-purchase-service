package com.hcltech.car_purchase_service.controller;

import com.hcltech.car_purchase_service.entity.Person;
import com.hcltech.car_purchase_service.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {
    @Autowired
    private final PersonService service;
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        List<Person> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/getOne={id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        Person one = service.getOne(id);
        return new ResponseEntity<>(one, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Person person){
        Person add = service.add(person);
        return new ResponseEntity<>(add, HttpStatus.OK);
    }

    @PutMapping("/update={id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Person person){
        Person update = service.update(id, person);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete={id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

    @GetMapping("/byRole={role}")
    public ResponseEntity<?> withRole(@PathVariable String role){
        return new ResponseEntity<>(service.withRole(role),HttpStatus.OK);

    }
}
