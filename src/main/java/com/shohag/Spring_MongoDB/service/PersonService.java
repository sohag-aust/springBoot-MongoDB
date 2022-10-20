package com.shohag.Spring_MongoDB.service;

import com.shohag.Spring_MongoDB.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    Long save(Person person);

    List<Person> getPersonStartWith(String name);

    void deletePerson(Long id);

    List<Person> getPersonsByAge(Integer minAge, Integer maxAge);
    List<Person> getPersonsByAgeUsingQueryAnnotation(Integer minAge, Integer maxAge);

    Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable);

    List<Person> getAllPersons();
}
