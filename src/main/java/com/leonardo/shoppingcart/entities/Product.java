package com.leonardo.shoppingcart.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder @AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(nullable=false, unique=true)
    private String cod;
    @Column(nullable=false)
    private String name;
    private String description;
    @Column(nullable=false)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name="cat_id")
    private Category category;
}
