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
    private Integer id;
    private BigDecimal amount;
}
