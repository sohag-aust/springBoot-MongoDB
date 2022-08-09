package com.shohag.Spring_MongoDB.service.impl;

import com.shohag.Spring_MongoDB.model.Person;
import com.shohag.Spring_MongoDB.repository.PersonRepo;
import com.shohag.Spring_MongoDB.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepo personRepo;

    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public Long save(Person person) {
        Person savedPerson = this.personRepo.save(person);
        return savedPerson.getId();
    }

    @Override
    public List<Person> getPersonStartWith(String name) {
        return this.personRepo.findByFirstNameStartsWith(name);
    }

    @Override
    public void deletePerson(Long id) {
        this.personRepo.deleteById(id);
    }
}
