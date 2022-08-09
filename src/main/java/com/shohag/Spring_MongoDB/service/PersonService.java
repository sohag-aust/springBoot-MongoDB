package com.shohag.Spring_MongoDB.service;

import com.shohag.Spring_MongoDB.model.Person;

import java.util.List;

public interface PersonService {
    Long save(Person person);

    List<Person> getPersonStartWith(String name);

    void deletePerson(Long id);
}