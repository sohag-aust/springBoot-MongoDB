package com.shohag.Spring_MongoDB.repository;

import com.shohag.Spring_MongoDB.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends MongoRepository<Person, Long> {

    List<Person> findByFirstNameStartsWith(String name);
    List<Person> findByAgeBetween(Integer min, Integer max); // it will operate as (>=min && <max)
}
