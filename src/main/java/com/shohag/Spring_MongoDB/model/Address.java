package com.shohag.Spring_MongoDB.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String house;
    private String road;
    private String city;
}
