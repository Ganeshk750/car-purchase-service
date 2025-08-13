package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.AddressDto;
import com.hcltech.car_purchase_service.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMappers {
    @Mapping(source = "personId",target = "person.id")
    Address toEntity(AddressDto addressDto);
    @Mapping(source = "person.id",target = "personId")
    AddressDto toDto(Address address);
    List<AddressDto>toDtoList(List<Address> addressList);
}
