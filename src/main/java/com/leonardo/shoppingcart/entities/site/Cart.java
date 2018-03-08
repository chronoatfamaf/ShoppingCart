package com.leonardo.shoppingcart.entities.site;

import com.leonardo.shoppingcart.entities.Customer;
import com.leonardo.shoppingcart.entities.Payment;
import com.leonardo.shoppingcart.entities.Product;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<LineItem> items;
    private Customer.CustomerBuilder customer;
    private Payment payment;

    public Cart() {
        items = new ArrayList<LineItem>();
        customer = Customer.builder();
        payment = new Payment();
    }

    public void addItem(Product product) {
        for (LineItem lineItem : items)
        {
            if(lineItem.getProduct().getCod().equals(product.getCod())){
                lineItem.setQuantity(lineItem.getQuantity()+1);
            }
        }
        LineItem item = new LineItem(product, 1);
        this.items.add(item);
    }

    public void updateItemQuantity(Product product, int quantity) {
        for (LineItem lineItem : items)
        {
            if(lineItem.getProduct().getCod().equals(product.getCod()))
            {
                lineItem.setQuantity(quantity);
            }
        }
    }

    public void removeItem(String cod) {
        LineItem  item = null;
        for (LineItem lineItem : items)
        {
            if(lineItem.getProduct().getCod().equals(cod))
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
        items = new ArrayList<>();
    }

    public int getItemCount() {
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

    public BigDecimal getTotalAmount() {
        BigDecimal amount = new BigDecimal("0.0");
        for (LineItem lineItem : items)
        {
            amount = amount.add(lineItem.getSubTotal());
        }
        return amount;
    }
}
