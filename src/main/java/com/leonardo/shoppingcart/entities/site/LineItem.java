package com.leonardo.shoppingcart.entities.site;

import com.leonardo.shoppingcart.entities.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LineItem {

    private Product product;
    private int quantity;

    LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal getSubTotal()
    {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
