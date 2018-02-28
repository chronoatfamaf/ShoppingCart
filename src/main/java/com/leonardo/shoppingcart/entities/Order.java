package com.leonardo.shoppingcart.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false, unique=true)
    private String orderNumber;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="order")
    private Set<OrderItem> items;

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="cust_id")
    private Customer customer;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="payment_id")
    private Payment payment;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order() { this.items = new HashSet<>(); }

    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getOrderNumber()
    {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public OrderStatus getStatus()
    {
        return status;
    }
    public void setStatus(OrderStatus status)
    {
        this.status = status;
    }

    public Set<OrderItem> getItems()
    {
        return items;
    }
    public void setItems(Set<OrderItem> items)
    {
        this.items = items;
    }

    public Customer getCustomer()
    {
        return customer;
    }
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment)
    {
        this.payment = payment;
    }

    public BigDecimal getTotalAmount() {
        BigDecimal amount = new BigDecimal("0.0");
        for (OrderItem item : items)
        {
            amount = amount.add(item.getSubTotal());
        }
        return amount;
    }
}
