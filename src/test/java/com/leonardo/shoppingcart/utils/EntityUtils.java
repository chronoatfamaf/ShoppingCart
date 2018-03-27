package com.leonardo.shoppingcart.utils;

import com.leonardo.shoppingcart.entities.*;

import java.math.BigDecimal;

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

    public static Order createDummyOrder(Customer customer) {
        return Order.builder()
                .id(1)
                .customer(customer)
                .status(OrderStatus.NEW)
                .build();
    }

    public static Payment createDummyPayment(Order order) {
        return Payment.builder()
                .id(1)
                .build();
    }

    public static Product createDummyProduct(Integer productId, String productCod, Category cat) {
        return Product.builder()
                .id(productId)
                .cod(productCod)
                .name("Default")
                .description("Default")
                .price(BigDecimal.valueOf(100.00))
                .category(cat)
                .build();
    }

    public static Category createDummyCategory(Integer idCat, String catName, Integer dOrder) {
        return Category.builder()
                .id(idCat)
                .name(catName)
                .disabled(false)
                .displayOrder(dOrder)
                .description("Default")
                .products(null)
                .build();
    }
}
