package com.hcltech.car_purchase_service.service.impl;

import com.hcltech.car_purchase_service.entity.Address;
import com.hcltech.car_purchase_service.repository.AddressRepository;
import com.hcltech.car_purchase_service.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    @Autowired
    private final AddressRepository repository;


    @Override
    public Address getById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Address not available for this id: " + id));
    }

    @Override
    public Address updateById(Long id, Address address){
        Address address1 = repository.findById(id).orElseThrow(() -> new RuntimeException("Address not available for this id: " + id));
        if (address1!=null) {
            address1=address;
            address1.setId(id);
            return repository.save(address1);
        }else {
            return null;
        }

    }

    @Override
    public String deleteById(Long id){
        if (repository.findById(id).orElseThrow(() -> new RuntimeException("Address not available for this id: " + id))!=null) {
            repository.deleteById(id);
            return "Deleted Successfully";
        }else {
            return "Not Deleted";
        }

    }

    @Override
    public Address add(Address address){
        return repository.save(address);
    }
}
