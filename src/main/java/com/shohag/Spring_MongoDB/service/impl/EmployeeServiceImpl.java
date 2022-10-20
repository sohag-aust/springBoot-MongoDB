package com.shohag.Spring_MongoDB.service.impl;

import com.shohag.Spring_MongoDB.model.Employee;
import com.shohag.Spring_MongoDB.repository.EmployeeRepoImpl;
import com.shohag.Spring_MongoDB.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepoImpl employeeRepoImpl;

    public EmployeeServiceImpl(EmployeeRepoImpl employeeRepoImpl) {
        this.employeeRepoImpl = employeeRepoImpl;
    }

    @Override
    public Employee save(Employee employee) {
        employee.setJoiningDate(new Date());
        return employeeRepoImpl.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepoImpl.findAll();
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepoImpl.save(employee); // upsert will perform here
    }

    @Override
    public long delete(Employee employee) {
        return employeeRepoImpl.delete(employee);
    }

    @Override
    public List<Employee> getBySalary(int salary) {
        return employeeRepoImpl.getBySalary(salary);
    }

    @Override
    public List<Employee> getByFirstName(String firstName) {
        return employeeRepoImpl.getByFirstName(firstName);
    }
}
