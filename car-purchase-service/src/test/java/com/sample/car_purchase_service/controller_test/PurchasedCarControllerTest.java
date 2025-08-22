package com.sample.car_purchase_service.controller_test;
import com.sample.car_purchase_service.controller.PurchasedCarController;
import com.sample.car_purchase_service.dto.PurchasedCarDto;
import com.sample.car_purchase_service.service.PurchasedCarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
        import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PurchasedCarControllerTest {

    @Mock
    private PurchasedCarService purchesedCarService;

    @InjectMocks
    private PurchasedCarController purchasedCarController;

    private PurchasedCarDto purchasedCarDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        purchasedCarDto = new PurchasedCarDto(); // Populate with sample data if needed
    }

    @Test
    void testGetAll() {
        when(purchesedCarService.getAll()).thenReturn(Collections.singletonList(purchasedCarDto));

        ResponseEntity<?> response = purchasedCarController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(purchasedCarDto), response.getBody());
        verify(purchesedCarService, times(1)).getAll();
    }

    @Test
    void testGetOne() {
        Long id = 1L;
        when(purchesedCarService.getbyId(id)).thenReturn(purchasedCarDto);

        ResponseEntity<?> response = purchasedCarController.getOne(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(purchasedCarDto, response.getBody());
        verify(purchesedCarService, times(1)).getbyId(id);
    }

    @Test
    void testAdd() {
        when(purchesedCarService.add(purchasedCarDto)).thenReturn(purchasedCarDto);

        ResponseEntity<?> response = purchasedCarController.add(purchasedCarDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(purchasedCarDto, response.getBody());
        verify(purchesedCarService, times(1)).add(purchasedCarDto);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        when(purchesedCarService.updateById(id, purchasedCarDto)).thenReturn(purchasedCarDto);

        ResponseEntity<?> response = purchasedCarController.update(id, purchasedCarDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(purchasedCarDto, response.getBody());
        verify(purchesedCarService, times(1)).updateById(id, purchasedCarDto);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        when(purchesedCarService.deleteById(id)).thenReturn("Deleted");

        ResponseEntity<?> response = purchasedCarController.delete(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Deleted", response.getBody());
        verify(purchesedCarService, times(2)).deleteById(id); // Called twice in controller
    }
}
