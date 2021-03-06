package com.leonardo.shoppingcart.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude="category")
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
