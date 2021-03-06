package com.leonardo.shoppingcart.service;

import com.leonardo.shoppingcart.repository.CustomerRepository;
import com.leonardo.shoppingcart.entities.Customer;
import com.leonardo.shoppingcart.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService
{
    @Autowired CustomerRepository customerRepository;

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Order> getCustomerOrders(String email) {
        return customerRepository.getCustomerOrders(email);
    }

}
