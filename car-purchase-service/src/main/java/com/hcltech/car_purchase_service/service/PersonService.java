package com.hcltech.car_purchase_service.service;

import com.hcltech.car_purchase_service.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAll();

    Person getOne(Long id);

    Person add(Person person);

    Person update(Long id, Person person);

    String delete(Long id);

    Optional<Person> withRole(String role);
}
