package com.hcltech.car_purchase_service.controller_test;

import com.hcltech.car_purchase_service.controller.AddressController;
import com.hcltech.car_purchase_service.dto.AddressDto;
import com.hcltech.car_purchase_service.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
        import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
class AddressControllerTest {

    @Mock
    private AddressService addressService;

    @InjectMocks
    private AddressController addressController;

    private AddressDto addressDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addressDto = new AddressDto(); // Populate with sample data if needed
    }

    @Test
    void testGetAll() {
        when(addressService.getAll()).thenReturn(Collections.emptyList());

        ResponseEntity<?> response = addressController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Collections.emptyList(), response.getBody());
        verify(addressService, times(1)).getAll();
    }

    @Test
    void testGetById() {
        Long id = 1L;
        when(addressService.getById(id)).thenReturn(addressDto);

        ResponseEntity<?> response = addressController.getById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(addressDto, response.getBody());
        verify(addressService, times(1)).getById(id);
    }

    @Test
    void testAdd() {
        when(addressService.add(addressDto)).thenReturn(addressDto);

        ResponseEntity<?> response = addressController.add(addressDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(addressDto, response.getBody());
        verify(addressService, times(1)).add(addressDto);
    }

    @Test
    void testUpdateById() {
        Long id = 1L;
        when(addressService.updateById(id, addressDto)).thenReturn(addressDto);

        ResponseEntity<?> response = addressController.updateById(id, addressDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(addressDto, response.getBody());
        verify(addressService, times(1)).updateById(id, addressDto);
    }

    @Test
    void testDeleteById() {
        Long id = 1L;
        when(addressService.deleteById(id)).thenReturn("Deleted");

        ResponseEntity<?> response = addressController.deleteById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Deleted", response.getBody());
        verify(addressService, times(1)).deleteById(id);
    }
}
