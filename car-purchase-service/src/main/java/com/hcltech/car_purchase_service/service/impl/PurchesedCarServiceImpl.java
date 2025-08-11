package com.hcltech.car_purchase_service.service.impl;

import com.hcltech.car_purchase_service.dto.PurchasedCarDto;
import com.hcltech.car_purchase_service.entity.PurchasedCar;
import com.hcltech.car_purchase_service.mapper.PurchasedCarMapper;
import com.hcltech.car_purchase_service.repository.PurchasedCerREpository;
import com.hcltech.car_purchase_service.service.PurchesedCarService;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchesedCarServiceImpl implements PurchesedCarService {
    @Autowired
    private final PurchasedCerREpository repository;
    @Autowired
    private PurchasedCarMapper purchasedCarMapper;

    @Override
    public List<PurchasedCarDto> getAll(){
        return purchasedCarMapper.toDtoList(repository.findAll());
    }

    @Override
    public PurchasedCarDto add(PurchasedCarDto purchasedCarDto){
        return purchasedCarMapper.toDto(repository.save(purchasedCarMapper.toEntity(purchasedCarDto)));
    }

    @Override
    public PurchasedCarDto getbyId(Long id){
        return purchasedCarMapper.toDto(repository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("No Purchedcar for id: " + id)));
    }
    @Override
    public PurchasedCarDto updateById(Long id, PurchasedCarDto purchasedCarDto){
        PurchasedCar update = repository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("No Purchedcar for id: " + id));
        if (update!=null) {
            update=purchasedCarMapper.toEntity(purchasedCarDto);
            update.setId(id);
            return purchasedCarMapper.toDto(repository.save(update));
        }else {
            return null;
        }
    }

    @Override
    public String deleteById(Long id){
        if (repository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("No Purchedcar for id: " + id))!=null) {
            repository.deleteById(id);
            return "Deleted Successfully";
        }else {
            return "Not Deleted";
        }
    }
}
