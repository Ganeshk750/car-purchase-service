package com.hcltech.car_purchase_service.mapper;

import com.hcltech.car_purchase_service.dto.AddressDto;
import com.hcltech.car_purchase_service.dto.PersonDto;
import com.hcltech.car_purchase_service.dto.PurchasedCarDto;
import com.hcltech.car_purchase_service.entity.Address;
import com.hcltech.car_purchase_service.entity.Person;
import com.hcltech.car_purchase_service.entity.PurchasedCar;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-12T22:47:16+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class PersonMappersImpl implements PersonMappers {

    @Autowired
    private AddressMappers addressMappers;
    @Autowired
    private PurchasedCarMappers purchasedCarMappers;

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
        person.setAddresses( addressDtoListToAddressList( personDto.getAddresses() ) );
        person.setSoldCars( purchasedCarDtoListToPurchasedCarList( personDto.getSoldCars() ) );
        person.setPurchasedCars( purchasedCarDtoListToPurchasedCarList( personDto.getPurchasedCars() ) );

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
        personDto.setAddresses( addressMappers.toDtoList( person.getAddresses() ) );
        personDto.setSoldCars( purchasedCarMappers.toDtoList( person.getSoldCars() ) );
        personDto.setPurchasedCars( purchasedCarMappers.toDtoList( person.getPurchasedCars() ) );

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

    protected List<Address> addressDtoListToAddressList(List<AddressDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressDto addressDto : list ) {
            list1.add( addressMappers.toEntity( addressDto ) );
        }

        return list1;
    }

    protected List<PurchasedCar> purchasedCarDtoListToPurchasedCarList(List<PurchasedCarDto> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchasedCar> list1 = new ArrayList<PurchasedCar>( list.size() );
        for ( PurchasedCarDto purchasedCarDto : list ) {
            list1.add( purchasedCarMappers.toEntity( purchasedCarDto ) );
        }

        return list1;
    }
}
