package com.shohag.Spring_MongoDB.controller;

import com.shohag.Spring_MongoDB.model.Employee;
import com.shohag.Spring_MongoDB.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PutMapping("/")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/")
    public long delete(@RequestBody Employee employee) {
        return employeeService.delete(employee);
    }

    @GetMapping("/salary")
    public List<Employee> getBySalary(@RequestParam int salary) {
        return employeeService.getBySalary(salary);
    }

    @GetMapping("/firstName")
    public List<Employee> getByFirstName(@RequestParam String firstName) {
        return employeeService.getByFirstName(firstName);
    }
}
