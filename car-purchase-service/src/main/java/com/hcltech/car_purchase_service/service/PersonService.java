package com.hcltech.car_purchase_service.service;

import com.hcltech.car_purchase_service.dto.PersonDto;
import com.hcltech.car_purchase_service.entity.Person;
import com.hcltech.car_purchase_service.enums.Role;

import java.util.List;

public interface PersonService {
    List<PersonDto> getAll();

    PersonDto getOne(Long id);

    PersonDto add(PersonDto personDto);

    PersonDto update(Long id, PersonDto personDto);

    String delete(Long id);

    List<PersonDto> withRole(Role role);
}
