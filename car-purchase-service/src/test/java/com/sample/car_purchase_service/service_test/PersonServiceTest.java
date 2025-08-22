package com.sample.car_purchase_service.service_test;

import com.sample.car_purchase_service.dto.PersonDto;
import com.sample.car_purchase_service.entity.Person;
import com.sample.car_purchase_service.enums.Role;
import com.sample.car_purchase_service.mapper.PersonMapper;
import com.sample.car_purchase_service.repository.PersonRepository;
import com.sample.car_purchase_service.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    PersonMapper personMapper;
    @Mock
    PersonRepository personRepository;
    @InjectMocks
    PersonServiceImpl personService;


    @Test
    void testGetAllPersons() {
        List<Person> personList = List.of(new Person(), new Person());
        List<PersonDto> dtoList = List.of(new PersonDto(), new PersonDto());

        Mockito.when(personRepository.findAll()).thenReturn(personList);
        Mockito.when(personMapper.toDtoList(personList)).thenReturn(dtoList);

        List<PersonDto> result = personService.getAll();

        Assertions.assertEquals(2, result.size());
        Mockito.verify(personRepository).findAll();
        Mockito.verify(personMapper).toDtoList(personList);
    }

    @Test
    void testGetOnePerson() {
        Long id = 1L;
        Person person = new Person();
        person.setId(id);
        PersonDto dto = new PersonDto();
        dto.setId(id);

        Mockito.when(personRepository.findById(id)).thenReturn(Optional.of(person));
        Mockito.when(personMapper.toDto(person)).thenReturn(dto);

        PersonDto result = personService.getOne(id);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.getId());
    }


    @Test
    void testAddPerson() {
        PersonDto dto = new PersonDto();
        dto.setFirst_name("John");

        Person person = new Person();
        person.setFirst_name("John");

        Mockito.when(personMapper.toEntity(dto)).thenReturn(person);
        Mockito.when(personRepository.save(person)).thenReturn(person);
        Mockito.when(personMapper.toDto(person)).thenReturn(dto);

        PersonDto result = personService.add(dto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("John", result.getFirst_name());
    }


    @Test
    void testUpdatePerson() {
        Long id = 1L;
        Person existing = new Person();
        existing.setId(id);

        PersonDto dto = new PersonDto();
        dto.setId(id);
        dto.setFirst_name("Updated");

        Person updatedEntity = new Person();
        updatedEntity.setId(id);
        updatedEntity.setFirst_name("Updated");

        Mockito.when(personRepository.findById(id)).thenReturn(Optional.of(existing));
        Mockito.when(personMapper.toEntity(dto)).thenReturn(updatedEntity);
        Mockito.when(personRepository.save(updatedEntity)).thenReturn(updatedEntity);
        Mockito.when(personMapper.toDto(updatedEntity)).thenReturn(dto);

        PersonDto result = personService.update(id, dto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Updated", result.getFirst_name());
    }


    @Test
    void testDeletePerson_Success() {
        Long id = 1L;

        Mockito.when(personRepository.existsById(id)).thenReturn(true);
        Mockito.doNothing().when(personRepository).deleteById(id);

        String result = personService.delete(id);

        Assertions.assertEquals("Deleted Successfully", result);
    }


    @Test
    void testDeletePerson_NotFound() {
        Long id = 2L;

        Mockito.when(personRepository.existsById(id)).thenReturn(false);

        String result = personService.delete(id);

        Assertions.assertEquals("Person with id: 2 is not found", result);
    }


    @Test
    void testWithRole() {
        Role role = Role.ADMIN;
        List<Person> people = List.of(new Person(), new Person());
        List<PersonDto> dtos = List.of(new PersonDto(), new PersonDto());

        Mockito.when(personRepository.findByRole(role)).thenReturn(people);
        Mockito.when(personMapper.toDtoList(people)).thenReturn(dtos);

        List<PersonDto> result = personService.withRole(role);

        Assertions.assertEquals(2, result.size());
    }

}
