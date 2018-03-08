package com.leonardo.shoppingcart.utils;

import com.leonardo.shoppingcart.entities.*;

public class EntityUtils {

    public static Customer createDummyCustomer() {
        return Customer.builder()
                .id(2)
                .firstName("Leonardo")
                .lastName("Emanuel")
                .email("leo@gmail.com")
                .password("$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS")
                .build();
    }

    public static Order createDummyOrder() {
        return Order.builder()
                .id(1)
                .status(OrderStatus.NEW)
                .build();
    }

    public static Payment createDummyPayment() {
        return Payment.builder()
                .id(1)
                .build();
    }

    public static Product createDummyProduct() {
        return Product.builder()
                .build();
    }
}
