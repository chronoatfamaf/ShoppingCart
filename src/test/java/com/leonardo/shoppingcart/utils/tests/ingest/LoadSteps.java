package com.leonardo.shoppingcart.utils.tests.ingest;

import com.leonardo.shoppingcart.entities.Customer;
import com.leonardo.shoppingcart.entities.Order;
import com.leonardo.shoppingcart.entities.Product;
import com.leonardo.shoppingcart.entities.site.Cart;
import com.leonardo.shoppingcart.repository.OrderRepository;
import com.leonardo.shoppingcart.repository.ProductRepository;
import com.leonardo.shoppingcart.service.CatalogService;
import com.leonardo.shoppingcart.service.OrderService;
import com.sun.org.apache.xml.internal.resolver.Catalog;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LoadSteps extends Steps {

    @Autowired
    private CatalogService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductRepository productRepository;

    private Order order;
    private Product product1;
    private Product product2;
    private Customer customer;

    @Given("product name $name, price $price and code $code")
    public void addProduct(String name, BigDecimal price, String code) {
        product1 = new Product();
        product1.setId(1);
        product1.setName(name);
        product1.setCod(code);
        product1.setPrice(price);
        productRepository.save(product1);
    }

    @Given("empty shopping order number $orderNumber")
    public void emptyShoppingCart(String orderNumber) {
        order = new Order();
        order.setOrderNumber(orderNumber);
        order.setId(1);
    }

    @Then("shopping order is empty")
    public void isEmpty() {
        assertNotNull(order);
    }

    @Then("add product $code to order")
    public void addProductToOrder(String code){
        List<Product> productList = new ArrayList<>();
        // needs implementation
    }
}
