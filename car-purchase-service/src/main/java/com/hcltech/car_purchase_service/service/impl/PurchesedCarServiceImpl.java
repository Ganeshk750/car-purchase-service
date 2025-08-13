package com.hcltech.car_purchase_service.service.impl;

import com.hcltech.car_purchase_service.dto.PurchasedCarDto;
import com.hcltech.car_purchase_service.entity.PurchasedCar;
import com.hcltech.car_purchase_service.mapper.PurchasedCarMappers;
import com.hcltech.car_purchase_service.repository.PurchasedCerREpository;
import com.hcltech.car_purchase_service.service.PurchesedCarService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchesedCarServiceImpl implements PurchesedCarService {
    private static final Logger logger = LoggerFactory.getLogger(PurchesedCarServiceImpl.class);
    @Autowired
    private final PurchasedCerREpository repository;
    @Autowired
    private PurchasedCarMappers purchasedCarMapper;

    @Override
    public List<PurchasedCarDto> getAll(){
        logger.info("Fetching all purchased cars");
        return purchasedCarMapper.toDtoList(repository.findAll());
    }

    @Override
    public PurchasedCarDto add(PurchasedCarDto purchasedCarDto){
        logger.info("Adding new purchased car: {}",purchasedCarDto);
        return purchasedCarMapper.toDto(repository.save(purchasedCarMapper.toEntity(purchasedCarDto)));
    }

    @Override
    public PurchasedCarDto getbyId(Long id){
        logger.info("Fetching purchased car by ID:{}",id);
        return purchasedCarMapper.toDto(repository.findById(id).orElseThrow(() ->{
            logger.error("No PurchasedCar found for ID:");
            return
                new OpenApiResourceNotFoundException("No Purchedcar for id: " + id);}
        ));
    }
    @Override
    public PurchasedCarDto updateById(Long id, PurchasedCarDto purchasedCarDto){
        logger.info("Updating purchased car with id:{}", id);
        PurchasedCar update = repository.findById(id).orElseThrow(() ->{
            logger.error("No PurchasedCar found for id:{}",id);
            return
                new OpenApiResourceNotFoundException("No Purchedcar for id: " + id);
        });
        if (update!=null) {
            update=purchasedCarMapper.toEntity(purchasedCarDto);
            update.setId(id);
            return purchasedCarMapper.toDto(repository.save(update));
        }else {
            logger.warn("Update failed: PurchasedCar with id {} not found",id);
            return null;
        }
    }

    @Override
    public String deleteById(Long id){
        logger.info("Deleting purchased car with ID:{}",id);
        if (repository.findById(id).orElseThrow(() ->{
            logger.error("No PurchasedCar found for ID:{}",id);
            return
                new OpenApiResourceNotFoundException("No Purchedcar for id: " + id);
        })!=null) {
            repository.deleteById(id);
            logger.info("Deleted purchased car with id:{}",id);
            return "Deleted Successfully";
        }else {
            logger.warn("Delete failed: PurchasedCar with ID{} not found",id);
            return "Not Deleted";
        }
    }
}
