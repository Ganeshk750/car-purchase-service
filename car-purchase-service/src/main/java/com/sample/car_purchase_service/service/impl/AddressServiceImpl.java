package com.sample.car_purchase_service.service.impl;
import com.sample.car_purchase_service.dto.AddressDto;
import com.sample.car_purchase_service.entity.Address;
import com.sample.car_purchase_service.mapper.AddressMapper;
import com.sample.car_purchase_service.repository.AddressRepository;
import com.sample.car_purchase_service.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Autowired
    private final AddressRepository repository;
    @Autowired
    private final AddressMapper addressMapper;

    @Override
    public AddressDto getById(Long id){
        logger.info("Fetching address with ID:{}", id);
        return addressMapper.toDto(repository.findById(id).orElseThrow(() -> {
            logger.error("Address not found for ID:{}", id);
            return new
                    OpenApiResourceNotFoundException("Address not available for this id:"+id);
        })

        );
    }

    @Override
    public AddressDto updateById(Long id, AddressDto addressDto){
        logger.info("Updating address with ID:{}", id);
        Address address1 = repository.findById(id).orElseThrow(() ->{
            logger.error("Cannot update - address not found for ID:{}",id);
            return
                    new OpenApiResourceNotFoundException("Address not available for this id: " + id);
        });
        if (address1!=null) {
            address1=addressMapper.toEntity(addressDto);
            address1.setId(id);
            logger.debug("Updated address entity before save: {}",address1);
            return addressMapper.toDto(repository.save(address1));
        }else {
            logger.warn("Address update failed for ID:{}",id);
            return null;
        }

    }

    @Override
    public String deleteById(Long id){
        logger.info("Attempting to delete address with ID:{}",id);
        if (repository.findById(id).orElseThrow(() -> {
            logger.error("Address not found for ID:");
        return
                new OpenApiResourceNotFoundException("Address not available for this id: " + id);
        })!=null) {
            repository.deleteById(id);
            logger.info("Deleted address successfully for ID:{}",id);
            return "Deleted Successfully";
        }else {
            logger.warn("Could not deleted address for ID:{}",id);
            return "Not Deleted";
        }

    }

    @Override
    public AddressDto add(AddressDto addressDto){
        logger.info("Adding new address:{}",addressDto);

        return addressMapper.toDto(repository.save(addressMapper.toEntity(addressDto)));
    }
    @Override
    public List<AddressDto> getAll(){
        return addressMapper.toDtoList(repository.findAll());
    }

}
