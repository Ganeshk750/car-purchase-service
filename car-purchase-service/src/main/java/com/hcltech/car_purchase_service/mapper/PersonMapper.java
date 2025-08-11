package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.PersonDto;
import com.hcltech.car_purchase_service.entity.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        AddressMapper.class,
        PurchasedCarMapper.class
})

public interface PersonMapper {

    Person toEntity(PersonDto personDto);
    PersonDto toDto(Person person);
    List<PersonDto> toDtoList(List<Person> personList);

}
