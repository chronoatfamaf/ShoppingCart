package com.leonardo.shoppingcart.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "payments")
public class Payment implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)

    /* Set Variables of Payment Entity */
    private Integer id;
    private BigDecimal amount;

    /* Payment Id */
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }

    /* Payment Amount */
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}
