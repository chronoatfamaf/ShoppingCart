package com.leonardo.shoppingcart.entities;

import javax.persistence.*;
import java.io.Serializable;
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

    public Order() { this.items = new HashSet<OrderItem>(); }

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

    public Set<OrderItem> getItems()
    {
        return items;
    }
    public void setItems(Set<OrderItem> items)
    {
        this.items = items;
    }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment)
    {
        this.payment = payment;
    }
}