package com.leonardo.shoppingcart.repository;

import com.leonardo.shoppingcart.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>
{
        Order findByOrderNumber(String orderNumber);
}
