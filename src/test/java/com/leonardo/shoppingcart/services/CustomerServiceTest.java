package com.leonardo.shoppingcart.services;

import com.leonardo.shoppingcart.entities.Customer;
import com.leonardo.shoppingcart.repository.CustomerRepository;
import com.leonardo.shoppingcart.service.CustomerService;
import com.leonardo.shoppingcart.utils.EntityUtils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository mockCustomerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer_1;

    @Before
    public void create() {
        initMocks(CustomerServiceTest.class);
        customer_1 = EntityUtils.createDummyCustomer();
        customerService.createCustomer(customer_1);
    }

    @Test
    public void addCustomerOnceTest() {
        Mockito.verify(mockCustomerRepository, Mockito.times(1)).save(customer_1);
    }


    @Test
    public void findByEmailNotNullTest() {
        when(mockCustomerRepository.findByEmail("leo@gmail.com")).thenReturn(customer_1);
        assertEquals(customerService.getCustomerByEmail("leo@gmail.com"),customer_1 );
    }

    @Test
    public void getCustomerOrdersTest() {
        when(mockCustomerRepository.getCustomerOrders("leo@gmail.com")).thenReturn(null);
        assertEquals(customerService.getCustomerOrders("leo@gmail.com"), null );
    }

}
