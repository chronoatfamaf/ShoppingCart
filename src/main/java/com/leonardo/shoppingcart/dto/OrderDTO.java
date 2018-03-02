package com.leonardo.shoppingcart.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class OrderDTO
{
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty @Email
    private String emailId;
    @NotEmpty
    private String phone;

    @NotEmpty
    private String addressLine1;
    private String addressLine2;
    @NotEmpty
    private String city;
    @NotEmpty
    private String state;
    @NotEmpty
    private String zipCode;
    @NotEmpty
    private String country;

    @NotEmpty
    private String billingFirstName;
    @NotEmpty
    private String billingLastName;
    @NotEmpty
    private String billingAddressLine1;
    private String billingAddressLine2;
    @NotEmpty
    private String billingCity;
    @NotEmpty
    private String billingState;
    @NotEmpty
    private String billingZipCode;
    @NotEmpty
    private String billingCountry;
}
