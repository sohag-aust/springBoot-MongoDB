package com.shohag.Spring_MongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressP {

    private String line1;
    private String line2;
    private String city;
    private String state;
    private int zipCode;
}
