package com.shohag.Spring_MongoDB.repository;

import com.shohag.Spring_MongoDB.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends MongoRepository<Person, Long> {

    List<Person> findByFirstNameStartsWith(String name);
    List<Person> findByAgeBetween(Integer min, Integer max); // it will operate as (>=min && <max)

    @Query(value = "{'age' : { $gt : ?0, $lt : ?1} }") // here age is the property of person entity
//    @Query(value = "{'age' : { $gt : ?0, $lt : ?1} }", fields = "{addresses: 0}") // suppose, if we don't want addresses field in the response
    List<Person> findPersonsByAgeBetween(Integer min, Integer max); // this query will provide similar result like its upper query at line: 14
}
