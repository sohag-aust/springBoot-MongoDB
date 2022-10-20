package com.shohag.Spring_MongoDB.service;

import com.shohag.Spring_MongoDB.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAll();

    Employee update(Employee employee);

    long delete(Employee employee);

    List<Employee> getBySalary(int salary);

    List<Employee> getByFirstName(String firstName);

    Map<String, Object> getEmployeeGroupBySalary();
}
