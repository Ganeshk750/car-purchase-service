package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.PersonDto;
import com.hcltech.car_purchase_service.entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-11T15:24:01+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toEntity(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( personDto.getId() );
        person.setFirst_name( personDto.getFirst_name() );
        person.setLast_name( personDto.getLast_name() );
        person.setEmail( personDto.getEmail() );
        person.setPhone_number( personDto.getPhone_number() );
        person.setRole( personDto.getRole() );
        person.setVerified( personDto.isVerified() );

        return person;
    }

    @Override
    public PersonDto toDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setId( person.getId() );
        personDto.setFirst_name( person.getFirst_name() );
        personDto.setLast_name( person.getLast_name() );
        personDto.setEmail( person.getEmail() );
        personDto.setPhone_number( person.getPhone_number() );
        personDto.setRole( person.getRole() );
        personDto.setVerified( person.isVerified() );

        return personDto;
    }

    @Override
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
