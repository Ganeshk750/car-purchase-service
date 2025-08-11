package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.AddressDto;
import com.hcltech.car_purchase_service.entity.Address;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-11T15:24:02+0530",
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

        address.setId( addressDto.getId() );
        address.setStreet( addressDto.getStreet() );
        address.setCity( addressDto.getCity() );
        address.setState( addressDto.getState() );
        address.setPostalCode( addressDto.getPostalCode() );
        address.setCountry( addressDto.getCountry() );

        return address;
    }

    @Override
    public AddressDto toDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setId( address.getId() );
        addressDto.setStreet( address.getStreet() );
        addressDto.setCity( address.getCity() );
        addressDto.setState( address.getState() );
        addressDto.setPostalCode( address.getPostalCode() );
        addressDto.setCountry( address.getCountry() );

        return addressDto;
    }

    @Override
    public List<AddressDto> toDtoList(List<AddressDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AddressDto> list = new ArrayList<AddressDto>( dtoList.size() );
        for ( AddressDto addressDto : dtoList ) {
            list.add( addressDto );
        }

        return list;
    }
}
