package com.leonardo.shoppingcart.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="addresses")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}