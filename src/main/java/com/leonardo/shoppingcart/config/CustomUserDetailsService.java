package com.leonardo.shoppingcart.config;

import com.leonardo.shoppingcart.entities.Customer;
import com.leonardo.shoppingcart.security.AuthenticatedUser;
import com.leonardo.shoppingcart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    CustomerService customerService;
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Customer customer = customerService.getCustomerByEmail(email);
        if(customer == null){
            throw new UsernameNotFoundException("Email "+email+" not found");
        }
        return new AuthenticatedUser(customer);
    }

}
