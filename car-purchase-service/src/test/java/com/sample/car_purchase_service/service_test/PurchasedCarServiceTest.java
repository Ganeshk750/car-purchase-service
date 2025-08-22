package com.sample.car_purchase_service.service_test;

import com.sample.car_purchase_service.dto.CarDto;
import com.sample.car_purchase_service.dto.PurchasedCarDto;
import com.sample.car_purchase_service.entity.Car;
import com.sample.car_purchase_service.entity.Person;
import com.sample.car_purchase_service.entity.PurchasedCar;
import com.sample.car_purchase_service.mapper.PurchasedCarMapper;
import com.sample.car_purchase_service.repository.PurchasedCerRepository;
import com.sample.car_purchase_service.service.CarService;
import com.sample.car_purchase_service.service.impl.PurchasedCarServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PurchasedCarServiceTest {
    @Mock
    private CarService carService;

    @Mock
    private PurchasedCerRepository purchasedCerRepository;

    @Mock
    private PurchasedCarMapper purchasedCarMapper;

    @InjectMocks
    private PurchasedCarServiceImpl purchasedCarService;


    @Test
    void testGetAllPurchasedCars() {
        PurchasedCarDto purchasedCarDto = new PurchasedCarDto();
        purchasedCarDto.setId(1L);
        purchasedCarDto.setCarId(2L);
        purchasedCarDto.setPaymentMethod("UPI");
        purchasedCarDto.setPurchaseDate(LocalDate.ofEpochDay(2022));
        purchasedCarDto.setPurchasePrice(5400.00);
        purchasedCarDto.setDelivered(true);
        purchasedCarDto.setBuyerId(1L);
        purchasedCarDto.setSellerId(2L);

        PurchasedCar purchasedCar=new PurchasedCar();
        purchasedCar.setId(1L);
        purchasedCar.setCar(new Car());
        purchasedCar.setPaymentMethod("UPI");
        purchasedCar.setPurchaseDate(LocalDate.ofEpochDay(2022));
        purchasedCar.setPurchasePrice(5400.00);
        purchasedCar.setDelivered(true);
        purchasedCar.setBuyer(new Person());
        purchasedCar.setSeller(new Person());


        ;
        List<PurchasedCar> carList = List.of(purchasedCar, purchasedCar);
        List<PurchasedCarDto> dtoList = List.of(purchasedCarDto,purchasedCarDto);

        Mockito.when(purchasedCerRepository.findAll()).thenReturn(carList);
        Mockito.when(purchasedCarMapper.toDtoList(carList)).thenReturn(dtoList);

        List<PurchasedCarDto> result = purchasedCarService.getAll();

        Assertions.assertEquals(2, result.size());
        Mockito.verify(purchasedCerRepository).findAll();
        Mockito.verify(purchasedCarMapper).toDtoList(carList);
    }


    @Test
    void testAddPurchasedCar() {
        PurchasedCarDto dto = new PurchasedCarDto();
        dto.setPaymentMethod("Cash");
        dto.setCarId(1L);

        PurchasedCar entity = new PurchasedCar();
        entity.setPaymentMethod("Cash");

        CarDto carDto = new CarDto();
        carDto.setAvailable(true);


        Mockito.when(carService.getById(dto.getCarId())).thenReturn(carDto);


        Mockito.when(carService.updateById(dto.getCarId(), carDto)).thenReturn(carDto);

        Mockito.when(purchasedCarMapper.toEntity(dto)).thenReturn(entity);
        Mockito.when(purchasedCerRepository.save(entity)).thenReturn(entity);
        Mockito.when(purchasedCarMapper.toDto(entity)).thenReturn(dto);

        PurchasedCarDto result = purchasedCarService.add(dto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Cash", result.getPaymentMethod());
    }




    @Test
    void testGetPurchasedCarById() {
        Long id = 1L;
        PurchasedCar entity = new PurchasedCar();
        entity.setId(id);
        entity.setPaymentMethod("UPI");

        PurchasedCarDto dto = new PurchasedCarDto();
        dto.setId(id);
        dto.setPaymentMethod("UPI");

        Mockito.when(purchasedCerRepository.findById(id)).thenReturn(Optional.of(entity));
        Mockito.when(purchasedCarMapper.toDto(entity)).thenReturn(dto);

        PurchasedCarDto result = purchasedCarService.getbyId(id);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("UPI", result.getPaymentMethod());
    }

    @Test
    void testUpdatePurchasedCarById() {
        Long id = 1L;

        PurchasedCar existing = new PurchasedCar();
        existing.setId(id);
        existing.setPaymentMethod("Cash");

        PurchasedCarDto updatedDto = new PurchasedCarDto();
        updatedDto.setId(id);
        updatedDto.setPaymentMethod("Net Banking");

        PurchasedCar updatedEntity = new PurchasedCar();
        updatedEntity.setId(id);
        updatedEntity.setPaymentMethod("Net Banking");

        Mockito.when(purchasedCerRepository.findById(id)).thenReturn(Optional.of(existing));
        Mockito.when(purchasedCarMapper.toEntity(updatedDto)).thenReturn(updatedEntity);
        Mockito.when(purchasedCerRepository.save(updatedEntity)).thenReturn(updatedEntity);
        Mockito.when(purchasedCarMapper.toDto(updatedEntity)).thenReturn(updatedDto);

        PurchasedCarDto result = purchasedCarService.updateById(id, updatedDto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Net Banking", result.getPaymentMethod());
    }


    @Test
    void testDeletePurchasedCarById() {
        Long id = 1L;
        PurchasedCar entity = new PurchasedCar();
        entity.setId(id);

        Mockito.when(purchasedCerRepository.findById(id)).thenReturn(Optional.of(entity));
        Mockito.doNothing().when(purchasedCerRepository).deleteById(id);

        String result = purchasedCarService.deleteById(id);

        Assertions.assertEquals("Deleted Successfully", result);
        Mockito.verify(purchasedCerRepository).deleteById(id);
    }



}
