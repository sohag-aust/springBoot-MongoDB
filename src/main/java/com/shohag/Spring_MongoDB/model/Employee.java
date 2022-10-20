package com.shohag.Spring_MongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Document
@Data
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int salary;
    private AddressP address;
    private Date joiningDate;

}
