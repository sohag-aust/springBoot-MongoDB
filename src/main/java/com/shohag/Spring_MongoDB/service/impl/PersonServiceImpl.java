package com.shohag.Spring_MongoDB.service.impl;

import com.shohag.Spring_MongoDB.model.Person;
import com.shohag.Spring_MongoDB.repository.PersonRepo;
import com.shohag.Spring_MongoDB.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepo personRepo;
    private MongoTemplate mongoTemplate;

    public PersonServiceImpl(PersonRepo personRepo, MongoTemplate mongoTemplate) {
        this.personRepo = personRepo;
        this.mongoTemplate = mongoTemplate;
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

    @Override
    public List<Person> getPersonsByAge(Integer minAge, Integer maxAge) {
        return this.personRepo.findByAgeBetween(minAge, maxAge);
    }

    @Override
    public List<Person> getPersonsByAgeUsingQueryAnnotation(Integer minAge, Integer maxAge) {
        return this.personRepo.findPersonsByAgeBetween(minAge, maxAge);
    }

    @Override
    public Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable) {
        Query query = new Query().with(pageable);
        List<Criteria> criteriaList = new ArrayList<>();

        if(name != null && !name.isEmpty()) {
            criteriaList.add(Criteria.where("firstName").regex(name));
        }
        if(minAge != null && maxAge != null) {
            criteriaList.add(Criteria.where("age").gte(minAge).lte(maxAge));
        }
        if(city != null && !city.isEmpty()) {
            criteriaList.add(Criteria.where("addresses.city").regex(city));
        }
        if(!criteriaList.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        }

        Page<Person> person = PageableExecutionUtils.getPage(
                mongoTemplate.find(query, Person.class),
                pageable,
                () -> mongoTemplate.count(query.skip(0).limit(0),Person.class)
        );

        return person;
    }
}
