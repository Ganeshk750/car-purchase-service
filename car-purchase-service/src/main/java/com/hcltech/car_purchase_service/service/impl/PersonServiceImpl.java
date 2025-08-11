package com.hcltech.car_purchase_service.service.impl;

import com.hcltech.car_purchase_service.entity.Person;
import com.hcltech.car_purchase_service.mapper.PersonMapper;
import com.hcltech.car_purchase_service.repository.PersonRepository;
import com.hcltech.car_purchase_service.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    private final PersonMapper personMapper;

    @Override
    public List<Person> getAll(){
        return repository.findAll();
    }
    @Override
    public Person getOne(Long id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }
    @Override
    public Person add(Person person){
        System.out.println(personMapper.toDto(person));
        System.out.println(person);
       repository.save(person);
        return null;
    }
    @Override
    public Person update(Long id, Person person){
        Person found = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        if (found != null) {
            found=person;
            found.setId(id);
          return   repository.save(found);

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
public Optional<Person> withRole(String role){
      Optional<Person> withRole=repository.findByRole(role);
      return withRole;
    }
}
