package com.leonardo.shoppingcart.entities.site;

import com.leonardo.shoppingcart.entities.Customer;
import com.leonardo.shoppingcart.entities.Payment;
import com.leonardo.shoppingcart.entities.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart
{
    private List<LineItem> items;
    private Customer customer;
    private Payment payment;

    public Cart()
    {
        items = new ArrayList<LineItem>();
        customer = new Customer();
        payment = new Payment();
    }

    public void addItem(Product product)
    {
        for (LineItem lineItem : items)
        {
            if(lineItem.getProduct().getPcode().equals(product.getPcode())){
                lineItem.setQuantity(lineItem.getQuantity()+1);
                return;
            }
        }
        LineItem item = new LineItem(product, 1);
        this.items.add(item);
    }

    public void updateItemQuantity(Product product, int quantity)
    {
        for (LineItem lineItem : items)
        {
            if(lineItem.getProduct().getPcode().equals(product.getPcode()))
            {
                lineItem.setQuantity(quantity);
            }
        }
    }

    public void removeItem(String pcode)
    {
        LineItem  item = null;
        for (LineItem lineItem : items)
        {
            if(lineItem.getProduct().getPcode().equals(pcode))
            {
                item = lineItem;
                break;
            }
        }
        if(item != null){
            items.remove(item);
        }
    }

    public void clearItems()
    {
        items = new ArrayList<LineItem>();
    }

    public int getItemCount()
    {
        int count = 0;
        for (LineItem lineItem : items) {
            count +=  lineItem.getQuantity();
        }
        return count;
    }

    public List<LineItem> getItems()
    {
        return items;
    }
    public void setItems(List<LineItem> items)
    {
        this.items = items;
    }
    public BigDecimal getTotalAmount()
    {
        BigDecimal amount = new BigDecimal("0.0");
        for (LineItem lineItem : items)
        {
            amount = amount.add(lineItem.getSubTotal());
        }
        return amount;
    }

    public Customer getCustomer()
    {
        return customer;
    }
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public Payment getPayment()
    {
        return payment;
    }
    public void setPayment(Payment payment)
    {
        this.payment = payment;
    }

}
