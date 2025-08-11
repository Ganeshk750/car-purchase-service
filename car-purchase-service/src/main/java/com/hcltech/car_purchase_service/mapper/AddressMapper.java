package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.AddressDto;
import com.hcltech.car_purchase_service.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AddressMapper {
    @Autowired
    private PersonMapper personMapper;
   public Address toEntity(AddressDto dto){
       Address address=new Address();
       address.setCity(dto.getCity());
       address.setCountry(dto.getCountry());
       address.setState(dto.getState());
       address.setStreet(dto.getStreet());
       address.setPostalCode(dto.getPostalCode());
       return address;
   }

    public AddressDto toDto(Address address){
        AddressDto dto=new AddressDto();
        dto.setId(address.getId());
        dto.setCity(address.getCity());
        dto.setCountry(address.getCountry());
        dto.setState(address.getState());
        dto.setStreet(address.getStreet());
        dto.setPostalCode(address.getPostalCode());
        return dto;
    }

    public List<AddressDto> toDtoList(List<Address> addressList){
        if ( addressList == null ) {
            return null;
        }

        List<AddressDto> list = new ArrayList<AddressDto>( addressList.size() );
        for ( Address address : addressList ) {
            list.add( toDto( address ) );
        }

        return list;
    }
}
