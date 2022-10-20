package com.shohag.Spring_MongoDB.repository;

import com.shohag.Spring_MongoDB.model.Employee;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepoImpl {

    private MongoTemplate mongoTemplate;

    public EmployeeRepoImpl(MongoTemplate mongoTemplate) {
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

    public Map<String, Object> getEmployeeGroupBySalary() {
//        Aggregation aggregation = Aggregation.newAggregation(Aggregation.group().sum("$salary").as("salaryCount"));
//        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("firstName").regex("BAT")));

//        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("firstName").regex("BAT")), Aggregation.group("firstName").count().as("total"));

        MatchOperation match = Aggregation.match(Criteria.where("firstName").regex("BAT"));
        GroupOperation group = Aggregation.group("firstName").count().as("total");
        Aggregation aggregation = Aggregation.newAggregation(match, group);

        return mongoTemplate.aggregate(aggregation, "employee", Employee.class).getRawResults();
    }
}
