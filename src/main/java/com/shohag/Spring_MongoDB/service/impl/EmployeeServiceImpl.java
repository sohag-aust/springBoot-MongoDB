package com.shohag.Spring_MongoDB.service.impl;

import com.shohag.Spring_MongoDB.model.Employee;
import com.shohag.Spring_MongoDB.repository.EmployeeRepo;
import com.shohag.Spring_MongoDB.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee save(Employee employee) {
        employee.setJoiningDate(new Date());
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepo.save(employee); // upsert will perform here
    }

    @Override
    public long delete(Employee employee) {
        return employeeRepo.delete(employee);
    }

    @Override
    public List<Employee> getBySalary(int salary) {
        return employeeRepo.getBySalary(salary);
    }

    @Override
    public List<Employee> getByFirstName(String firstName) {
        return employeeRepo.getByFirstName(firstName);
    }
}
