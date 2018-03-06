package com.leonardo.shoppingcart.entities;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CustomerTest {

    @Mock
    private Customer customerObj = mock(Customer.class); // Object needs to be mocked

    @Before
    public void create(){
        initMocks(this); // Initialize mock class above
        when(customerObj.getId()).thenReturn(1); // Configure
    }

    @Test
    public void getId() {
        assertSame(1, customerObj.getId());
    }

    @Test
    public void getFirstName() {
    }

    @Test
    public void getLastName() {
    }

    @Test
    public void getEmail() {
    }

    @Test
    public void getPassword() {
    }

    @Test
    public void setId() {
    }

    @Test
    public void setFirstName() {
    }

    @Test
    public void setLastName() {
    }

    @Test
    public void setEmail() {
    }

    @Test
    public void setPassword() {
    }
}