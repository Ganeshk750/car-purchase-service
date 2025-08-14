package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.AddressDto;
import com.hcltech.car_purchase_service.entity.Address;
import com.hcltech.car_purchase_service.entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-13T22:29:57+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toEntity(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setPerson( addressDtoToPerson( addressDto ) );
        address.setId( addressDto.getId() );
        address.setStreet( addressDto.getStreet() );
        address.setCity( addressDto.getCity() );
        address.setPostalCode( addressDto.getPostalCode() );
        address.setState( addressDto.getState() );
        address.setCountry( addressDto.getCountry() );

        return address;
    }

    @Override
    public AddressDto toDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setPersonId( addressPersonId( address ) );
        addressDto.setId( address.getId() );
        addressDto.setStreet( address.getStreet() );
        addressDto.setCity( address.getCity() );
        addressDto.setState( address.getState() );
        addressDto.setPostalCode( address.getPostalCode() );
        addressDto.setCountry( address.getCountry() );

        return addressDto;
    }

    @Override
    public List<AddressDto> toDtoList(List<Address> addressList) {
        if ( addressList == null ) {
            return null;
        }

        List<AddressDto> list = new ArrayList<AddressDto>( addressList.size() );
        for ( Address address : addressList ) {
            list.add( toDto( address ) );
        }

        return list;
    }

    protected Person addressDtoToPerson(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( addressDto.getPersonId() );

        return person;
    }

    private Long addressPersonId(Address address) {
        if ( address == null ) {
            return null;
        }
        Person person = address.getPerson();
        if ( person == null ) {
            return null;
        }
        Long id = person.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
