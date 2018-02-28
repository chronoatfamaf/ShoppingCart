package com.leonardo.shoppingcart.service;

import com.leonardo.shoppingcart.entities.Order;
import com.leonardo.shoppingcart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService
{
    @Autowired OrderRepository orderRepository;

    public Order createOrder(Order order)
    {
        order.setOrderNumber(String.valueOf(System.currentTimeMillis()));
        return orderRepository.save(order);
    }

    public Order getOrder(String orderNumber)
    {
        return orderRepository.findByOrderNumber(orderNumber);
    }

    public List<Order> getAllOrders()
    {
        Sort sort = new Sort(Sort.Direction.DESC, "Id");
        return orderRepository.findAll(sort);
    }

    public Order updateOrder(Order order)
    {
        Order o = getOrder(order.getOrderNumber());
        return orderRepository.save(o);
    }

}
