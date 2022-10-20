package com.shohag.Spring_MongoDB.repository;

import com.shohag.Spring_MongoDB.model.Employee;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepo {

    private MongoTemplate mongoTemplate;

    public EmployeeRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Employee save(Employee employee) {
        return mongoTemplate.save(employee);
    }

    public List<Employee> findAll() {
        return mongoTemplate.findAll(Employee.class);
    }

    public long delete(Employee employee) {
        return mongoTemplate.remove(employee).getDeletedCount();
    }

    public List<Employee> getBySalary(int salary) {
        Query query = new Query(Criteria.where("salary").gte(salary));
        return mongoTemplate.find(query, Employee.class);
    }

    public List<Employee> getByFirstName(String firstName) {
        Query query = new Query(Criteria.where("firstName").regex("^"+firstName));
        return mongoTemplate.find(query, Employee.class);
    }
}
