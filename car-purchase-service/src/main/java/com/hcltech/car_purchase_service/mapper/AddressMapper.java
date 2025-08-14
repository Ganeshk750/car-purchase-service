package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.AddressDto;
import com.hcltech.car_purchase_service.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    @Mapping(target = "person.id", source = "personId")
    Address toEntity(AddressDto addressDto);
    @Mapping(target = "personId", source = "person.id")
    AddressDto toDto(Address address);
    List<AddressDto>toDtoList(List<Address> addressList);
}
