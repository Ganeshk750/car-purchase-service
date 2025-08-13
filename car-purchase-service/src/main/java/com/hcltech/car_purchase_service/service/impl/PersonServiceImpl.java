package com.hcltech.car_purchase_service.service.impl;

import com.hcltech.car_purchase_service.dto.PersonDto;
import com.hcltech.car_purchase_service.entity.Person;
import com.hcltech.car_purchase_service.enums.Role;
import com.hcltech.car_purchase_service.mapper.PersonMappers;
import com.hcltech.car_purchase_service.repository.PersonRepository;
import com.hcltech.car_purchase_service.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    private final PersonMappers personMapper;


    @Override
    public List<PersonDto> getAll(){
        return personMapper.toDtoList(repository.findAll());

    }
    @Override
    public PersonDto getOne(Long id){
        PersonDto found = personMapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("not found")));
        return found;
    }
    @Override
    public PersonDto add(PersonDto personDto){
        Person save = repository.save(personMapper.toEntity(personDto));
        return personMapper.toDto(save);
    }
    @Override
    public PersonDto update(Long id, PersonDto personDto){
        Person found = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        if (found != null) {
            found=personMapper.toEntity(personDto);
            found.setId(id);
          return  personMapper.toDto(repository.save(found));

        }
        return null;
    }
    @Override
    public String delete(Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Deleted Successfully";

        }
        return "Person with id: "+id+" is not found";
    }
@Override
public List<PersonDto> withRole(Role role){

      return personMapper.toDtoList(repository.findByRole(role));
    }
}
