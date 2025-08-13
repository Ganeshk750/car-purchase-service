package com.hcltech.car_purchase_service.service.impl;

import com.hcltech.car_purchase_service.dto.AddressDto;
import com.hcltech.car_purchase_service.entity.Address;
import com.hcltech.car_purchase_service.mapper.AddressMappers;
import com.hcltech.car_purchase_service.repository.AddressRepository;
import com.hcltech.car_purchase_service.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    @Autowired
    private final AddressRepository repository;
    @Autowired
    private final AddressMappers addressMapper;

    @Override
    public AddressDto getById(Long id){
        return addressMapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Address not available for this id: " + id)));
    }

    @Override
    public AddressDto updateById(Long id, AddressDto addressDto){
        Address address1 = repository.findById(id).orElseThrow(() -> new RuntimeException("Address not available for this id: " + id));
        if (address1!=null) {
            address1=addressMapper.toEntity(addressDto);
            address1.setId(id);
            return addressMapper.toDto(repository.save(address1));
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
    public AddressDto add(AddressDto addressDto){
        return addressMapper.toDto(repository.save(addressMapper.toEntity(addressDto)));
    }
    @Override
    public List<AddressDto> getAll(){
        return addressMapper.toDtoList(repository.findAll());
    }

}
