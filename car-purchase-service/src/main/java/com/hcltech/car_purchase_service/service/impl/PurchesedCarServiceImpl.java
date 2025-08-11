package com.hcltech.car_purchase_service.service.impl;

import com.hcltech.car_purchase_service.entity.PurchasedCar;
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

    @Override
    public List<PurchasedCar> getAll(){
        return repository.findAll();
    }

    @Override
    public PurchasedCar add(PurchasedCar purchasedCar){
        return repository.save(purchasedCar);
    }

    @Override
    public PurchasedCar getbyId(Long id){
        return repository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("No Purchedcar for id: " + id));
    }

    @Override
    public PurchasedCar updateById(Long id, PurchasedCar purchasedCar){
        PurchasedCar update = repository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("No Purchedcar for id: " + id));
        if (update!=null) {
            update=purchasedCar;
            update.setId(id);
            return repository.save(update);
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
