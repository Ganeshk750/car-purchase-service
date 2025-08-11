package com.hcltech.car_purchase_service.mapper;


import com.hcltech.car_purchase_service.dto.AddressDto;
import com.hcltech.car_purchase_service.dto.PersonDto;
import com.hcltech.car_purchase_service.entity.Address;
import com.hcltech.car_purchase_service.entity.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class PersonMapper {
    private AddressMapper addressMapper;

    public Person toEntity(PersonDto dto){
        Person person = new Person();
        person.setFirst_name(dto.getFirst_name());
        person.setLast_name(dto.getLast_name());
        person.setEmail(dto.getEmail());
        person.setRole(dto.getRole());
        person.setPhone_number(dto.getPhone_number());
        person.setVerified(dto.isVerified());
        return person;
    }

    public PersonDto toDto(Person person){
        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setFirst_name(person.getFirst_name());
        dto.setLast_name(person.getLast_name());
        dto.setEmail(person.getEmail());
        dto.setRole(person.getRole());
        dto.setPhone_number(person.getPhone_number());
        dto.setVerified(person.isVerified());
        return dto;
    }

    public List<PersonDto> toDtoList(List<Person> personList) {
        if ( personList == null ) {
            return null;
        }

        List<PersonDto> list = new ArrayList<PersonDto>( personList.size() );
        for ( Person person : personList ) {
            list.add( toDto( person ) );
        }

        return list;
    }


}
