package com.shohag.Spring_MongoDB.controller;

import com.shohag.Spring_MongoDB.model.Person;
import com.shohag.Spring_MongoDB.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/")
    public Long save(@RequestBody Person person) {
        return this.personService.save(person);
    }

    @GetMapping("/getPersonWithName")
    public List<Person> getPersonStartWith(@RequestParam("name") String name) {
        return this.personService.getPersonStartWith(name);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        this.personService.deletePerson(id);
    }

    @GetMapping("/getByAge")
    public List<Person> getPersonsByAge(@RequestParam Integer minAge, @RequestParam Integer maxAge) {
        return this.personService.getPersonsByAge(minAge, maxAge);
    }

    @GetMapping("/")
    public List<Person> getAll() {
        return this.personService.getAllPersons();
    }

    @GetMapping("/getByAgeUsingQueryAnnotation")
    public List<Person> getPersonsByAgeUsingQueryAnnotation(@RequestParam Integer minAge, @RequestParam Integer maxAge) {
        return this.personService.getPersonsByAge(minAge, maxAge);
    }

    @GetMapping("/search")
    public Page<Person> searchPerson(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) Integer minAge,
                                     @RequestParam(required = false) Integer maxAge,
                                     @RequestParam(required = false) String city,
                                     @RequestParam(defaultValue = "0") Integer pageIndex,
                                     @RequestParam(defaultValue = "5") Integer pageSize) {

        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        return this.personService.search(name, minAge, maxAge, city, pageable);
    }
}
