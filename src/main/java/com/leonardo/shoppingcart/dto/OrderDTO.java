package com.leonardo.shoppingcart.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class OrderDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @NotEmpty(message="FirstName is required")
    private String firstName;

    @NotEmpty(message="LastName is required")
    private String lastName;

    @NotEmpty(message="EmailId is required")
    @Email
    private String emailId;

    @NotEmpty(message="FirstName is required")
    private String billingFirstName;

    @NotEmpty(message="LastName is required")
    private String billingLastName;

    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmailId()
    {
        return emailId;
    }
    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }

}
