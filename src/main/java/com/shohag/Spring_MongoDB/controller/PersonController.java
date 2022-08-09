package com.shohag.Spring_MongoDB.controller;

import com.shohag.Spring_MongoDB.model.Person;
import com.shohag.Spring_MongoDB.service.PersonService;
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
}
