package com.hcltech.car_purchase_service.service;

import com.hcltech.car_purchase_service.entity.Address;

public interface AddressService {
    Address getById(Long id);

    Address updateById(Long id, Address address);

    String deleteById(Long id);

    Address add(Address address);
}
