package com.leonardo.shoppingcart.services;

import com.leonardo.shoppingcart.entities.Customer;
import com.leonardo.shoppingcart.entities.Order;
import com.leonardo.shoppingcart.repository.CustomerRepository;
import com.leonardo.shoppingcart.repository.OrderRepository;
import com.leonardo.shoppingcart.service.CustomerService;
import com.leonardo.shoppingcart.service.OrderService;
import com.leonardo.shoppingcart.utils.EntityUtils;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.any;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository mockCustomerRepository;

    @InjectMocks
    private CustomerService customerService;

    @InjectMocks
    private OrderService orderService;

    private Customer customer_1;
    private Order order_1;

    @Before
    public void create() {
        initMocks(CustomerServiceTest.class);
        customer_1 = EntityUtils.createDummyCustomer();
        customerService.createCustomer(customer_1);
    }

    @Test
    public void addCustomerOnceTest() {
        verify(mockCustomerRepository, times(1)).save(customer_1);
    }

    @Test
    public void findByEmailNotNullTest() {
        when(mockCustomerRepository.findByEmail("leo@gmail.com")).thenReturn(customer_1);
        assertEquals(customerService.getCustomerByEmail("leo@gmail.com"),customer_1 );
    }

    @Test
    public void getCustomerZeroOrdersTest() {
        when(mockCustomerRepository.getCustomerOrders("leo@gmail.com")).thenReturn(null);
        assertEquals(customerService.getCustomerOrders("leo@gmail.com"), null );
    }

    @Test
    public void getCustomerMoreThanZeroOrdersTest() {
        order_1 = EntityUtils.createDummyOrder(customer_1);
        orderService.createOrder(order_1);
        List<Order> list_orders = new ArrayList<>();
        list_orders.add(order_1);
        when(mockCustomerRepository.getCustomerOrders("leo@gmail.com")).thenReturn(list_orders);
        verify(mockCustomerRepository, times(1)).save(customer_1);
        assertEquals(customerService.getCustomerOrders("leo@gmail.com"), list_orders );
    }

    @Test
    public void createClientSuccessfully() {
        when(mockCustomerRepository.findByEmail("leo@gmail.com")).thenReturn(customer_1);
        Mockito.doAnswer(returnsFirstArg()).when(mockCustomerRepository).save(customer_1);
        assertEquals("Leonardo", customer_1.getFirstName());
        assertNotNull(customer_1.getId());
    }
}
