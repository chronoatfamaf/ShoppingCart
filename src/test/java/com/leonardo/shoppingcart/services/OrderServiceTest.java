package com.leonardo.shoppingcart.services;

import com.leonardo.shoppingcart.entities.Order;
import com.leonardo.shoppingcart.repository.OrderRepository;
import com.leonardo.shoppingcart.service.OrderService;
import com.leonardo.shoppingcart.utils.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository mockOrderRepository;

    @InjectMocks
    private OrderService orderService;

    private Order order_1;

    @Before
    public void create() {
        initMocks(OrderServiceTest.class);
        order_1 = EntityUtils.createDummyOrder(null);
        orderService.createOrder(order_1);
    }

    @Test
    public void createOrderOnceTest() {
        verify(mockOrderRepository, times(1)).save(order_1);
    }

    @Test
    public void getOrderByNumberTest () {
        when(mockOrderRepository.findByOrderNumber(order_1.getOrderNumber())).thenReturn(order_1);
        assertNotNull(orderService.getOrder(order_1.getOrderNumber()));
        verify(mockOrderRepository,times(1)).findByOrderNumber(order_1.getOrderNumber());
    }
}
