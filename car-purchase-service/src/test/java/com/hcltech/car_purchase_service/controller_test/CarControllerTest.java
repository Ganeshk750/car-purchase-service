package com.hcltech.car_purchase_service.controller_test;

import com.hcltech.car_purchase_service.controller.CarController;
import com.hcltech.car_purchase_service.dto.CarDto;
import com.hcltech.car_purchase_service.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CarControllerTest {

    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;

    private CarDto carDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        carDto = new CarDto(); // Populate with sample data if needed
    }

    @Test
    void testGetAll() {
        when(carService.getAll()).thenReturn(Collections.singletonList(carDto));

        ResponseEntity<?> response = carController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(carDto), response.getBody());
        verify(carService, times(1)).getAll();
    }

    @Test
    void testGetOne() {
        Long id = 1L;
        when(carService.getById(id)).thenReturn(carDto);

        ResponseEntity<?> response = carController.getOne(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(carDto, response.getBody());
        verify(carService, times(1)).getById(id);
    }

    @Test
    void testAdd() {
        when(carService.add(carDto)).thenReturn(carDto);

        ResponseEntity<?> response = carController.add(carDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(carDto, response.getBody());
        verify(carService, times(1)).add(carDto);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        when(carService.updateById(id, carDto)).thenReturn(carDto);

        ResponseEntity<?> response = carController.update(id, carDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(carDto, response.getBody());
        verify(carService, times(1)).updateById(id, carDto);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        when(carService.deleteById(id)).thenReturn("Deleted");

        ResponseEntity<?> response = carController.delete(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Deleted", response.getBody());
        verify(carService, times(1)).deleteById(id);
    }
}


