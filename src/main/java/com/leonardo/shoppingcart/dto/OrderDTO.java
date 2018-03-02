package com.leonardo.shoppingcart.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class OrderDTO
{
    @NotEmpty(message="FirstName is required")
    private String firstName;
    @NotEmpty(message="LastName is required")
    private String lastName;
    @NotEmpty(message="EmailId is required")
    @Email
    private String emailId;
    @NotEmpty(message="Phone is required")
    private String phone;

    @NotEmpty(message="Address Line1 is required")
    private String addressLine1;
    private String addressLine2;
    @NotEmpty(message="City is required")
    private String city;
    @NotEmpty(message="State is required")
    private String state;
    @NotEmpty(message="ZipCode is required")
    private String zipCode;
    @NotEmpty(message="Country is required")
    private String country;

    @NotEmpty(message="FirstName is required")
    private String billingFirstName;
    @NotEmpty(message="LastName is required")
    private String billingLastName;
    @NotEmpty(message="Address Line1 is required")
    private String billingAddressLine1;
    private String billingAddressLine2;
    @NotEmpty(message="City is required")
    private String billingCity;
    @NotEmpty(message="State is required")
    private String billingState;
    @NotEmpty(message="ZipCode is required")
    private String billingZipCode;
    @NotEmpty(message="Country is required")
    private String billingCountry;
}
