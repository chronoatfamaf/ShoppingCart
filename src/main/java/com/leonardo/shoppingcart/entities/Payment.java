package com.leonardo.shoppingcart.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
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
