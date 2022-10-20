package com.shohag.Spring_MongoDB.repository;

import com.shohag.Spring_MongoDB.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee, String> {
}
