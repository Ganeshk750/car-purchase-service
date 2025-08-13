package com.hcltech.car_purchase_service.service;

import com.hcltech.car_purchase_service.dto.AddressDto;
import com.hcltech.car_purchase_service.entity.Address;
import com.hcltech.car_purchase_service.entity.Person;

import java.util.List;

public interface AddressService {
    AddressDto getById(Long id);

    AddressDto updateById(Long id, AddressDto addressDto);

    String deleteById(Long id);

    AddressDto add(AddressDto addressDto);

    List<AddressDto> getAll();
}
