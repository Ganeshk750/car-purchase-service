package com.hcltech.car_purchase_service.controller_test;
import com.hcltech.car_purchase_service.controller.PersonController;
import com.hcltech.car_purchase_service.dto.PersonDto;
import com.hcltech.car_purchase_service.enums.Role;
import com.hcltech.car_purchase_service.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
        import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PersonControllerTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    private PersonDto personDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        personDto = new PersonDto(); // Populate with sample data if needed
    }

    @Test
    void testGetAll() {
        when(personService.getAll()).thenReturn(Collections.singletonList(personDto));

        ResponseEntity<?> response = personController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(personDto), response.getBody());
        verify(personService, times(1)).getAll();
    }

    @Test
    void testGetOne() {
        Long id = 1L;
        when(personService.getOne(id)).thenReturn(personDto);

        ResponseEntity<?> response = personController.getOne(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(personDto, response.getBody());
        verify(personService, times(1)).getOne(id);
    }

    @Test
    void testGetByRole() {
        Role role = Role.ADMIN; // Replace with an actual enum value from your Role enum
        when(personService.withRole(role)).thenReturn(Collections.singletonList(personDto));

        ResponseEntity<?> response = personController.byrole(role);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(personDto), response.getBody());
        verify(personService, times(1)).withRole(role);
    }

    @Test
    void testAdd() {
        when(personService.add(personDto)).thenReturn(personDto);

        ResponseEntity<?> response = personController.add(personDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(personDto, response.getBody());
        verify(personService, times(1)).add(personDto);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        when(personService.update(id, personDto)).thenReturn(personDto);

        ResponseEntity<?> response = personController.update(id, personDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(personDto, response.getBody());
        verify(personService, times(1)).update(id, personDto);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        when(personService.delete(id)).thenReturn("Deleted");

        ResponseEntity<?> response = personController.delete(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Deleted", response.getBody());
        verify(personService, times(2)).delete(id); // Called twice in controller
    }
}
