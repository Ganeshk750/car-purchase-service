package com.sample.car_purchase_service.service_test;

import com.sample.car_purchase_service.dto.AddressDto;
import com.sample.car_purchase_service.entity.Address;
import com.sample.car_purchase_service.entity.Person;
import com.sample.car_purchase_service.mapper.AddressMapper;
import com.sample.car_purchase_service.repository.AddressRepository;
import com.sample.car_purchase_service.service.impl.AddressServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    @Mock
    AddressMapper addressMapper;
    @Mock
    AddressRepository addressRepository;
    @InjectMocks
    AddressServiceImpl addressService;
    @Test
    void addressAddTest() {
        Address address = new Address();
        Person person = new Person();
        address.setId(1L);
        address.setStreet("sadsfdsf");
        address.setCity("sadsfdsf");
        address.setState("sadsfdsf");
        address.setCountry("sadsfdsf");
        address.setPostalCode("98765");
        address.setPerson(person);

        AddressDto addressDto = new AddressDto();
        addressDto.setId(1L);
        addressDto.setStreet("sadsfdsf");
        addressDto.setCity("sadsfdsf");
        addressDto.setState("sadsfdsf");
        addressDto.setCountry("sadsfdsf");
        addressDto.setPostalCode("98765");

        Mockito.when(addressMapper.toEntity(addressDto)).thenReturn(address);
        Mockito.when(addressRepository.save(address)).thenReturn(address);
        Mockito.when(addressMapper.toDto(address)).thenReturn(addressDto);

        AddressDto added = addressService.add(addressDto);

        Assertions.assertNotNull(added);
        Assertions.assertEquals(addressDto.getId(), added.getId());
    }

    @Test
    void addressUpdateTest() {
        Long id = 1L;

        Address existingAddress = new Address();
        existingAddress.setId(id);
        existingAddress.setStreet("Old Street");
        existingAddress.setCity("Old City");
        existingAddress.setState("Old State");
        existingAddress.setCountry("Old Country");
        existingAddress.setPostalCode("12345");

        AddressDto updatedDto = new AddressDto();
        updatedDto.setId(id);
        updatedDto.setStreet("New Street");
        updatedDto.setCity("New City");
        updatedDto.setState("New State");
        updatedDto.setCountry("New Country");
        updatedDto.setPostalCode("54321");

        Address updatedEntity = new Address();
        updatedEntity.setId(id);
        updatedEntity.setStreet("New Street");
        updatedEntity.setCity("New City");
        updatedEntity.setState("New State");
        updatedEntity.setCountry("New Country");
        updatedEntity.setPostalCode("54321");

        Mockito.when(addressRepository.findById(id)).thenReturn(Optional.of(existingAddress));
        Mockito.when(addressMapper.toEntity(updatedDto)).thenReturn(updatedEntity);
        Mockito.when(addressRepository.save(updatedEntity)).thenReturn(updatedEntity);
        Mockito.when(addressMapper.toDto(updatedEntity)).thenReturn(updatedDto);

        AddressDto result = addressService.updateById(id, updatedDto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(updatedDto.getStreet(), result.getStreet());
        Assertions.assertEquals(updatedDto.getCity(), result.getCity());
        Assertions.assertEquals(updatedDto.getPostalCode(), result.getPostalCode());

        Mockito.verify(addressRepository).findById(id);
        Mockito.verify(addressRepository).save(updatedEntity);
        Mockito.verify(addressMapper).toEntity(updatedDto);
        Mockito.verify(addressMapper).toDto(updatedEntity);
    }


    @Test
    void addressGetAllTest() {
        List<Address> addressList = new ArrayList<>();
        Address address1 = new Address();
        address1.setId(1L);
        address1.setStreet("Street 1");

        Address address2 = new Address();
        address2.setId(2L);
        address2.setStreet("Street 2");

        addressList.add(address1);
        addressList.add(address2);

        List<AddressDto> dtoList = new ArrayList<>();
        AddressDto dto1 = new AddressDto();
        dto1.setId(1L);
        dto1.setStreet("Street 1");

        AddressDto dto2 = new AddressDto();
        dto2.setId(2L);
        dto2.setStreet("Street 2");

        dtoList.add(dto1);
        dtoList.add(dto2);

        Mockito.when(addressRepository.findAll()).thenReturn(addressList);
        Mockito.when(addressMapper.toDtoList(addressList)).thenReturn(dtoList);

        List<AddressDto> result = addressService.getAll();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Street 1", result.get(0).getStreet());
        Assertions.assertEquals("Street 2", result.get(1).getStreet());
    }


    @Test
    void addressGetByIdTest() {
        Long id = 1L;
        Address address = new Address();
        address.setId(id);
        address.setStreet("Main Street");

        AddressDto addressDto = new AddressDto();
        addressDto.setId(id);
        addressDto.setStreet("Main Street");

        Mockito.when(addressRepository.findById(id)).thenReturn(Optional.of(address));
        Mockito.when(addressMapper.toDto(address)).thenReturn(addressDto);

        AddressDto result = addressService.getById(id);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Main Street", result.getStreet());
    }


    @Test
    void addressDeleteTest() {
        Long id = 1L;
        Address address = new Address();
        address.setId(id);

        Mockito.when(addressRepository.findById(id)).thenReturn(Optional.of(address));
        Mockito.doNothing().when(addressRepository).deleteById(id);

        String result = addressService.deleteById(id);

        Assertions.assertEquals("Deleted Successfully", result);
        Mockito.verify(addressRepository).deleteById(id);
    }

}
