package com.leonardo.shoppingcart.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(nullable=false, unique=true)
    @NotEmpty
    private String name;
    @Column(length=1024)
    private String description;
    @Column(name="disp_order")
    private Integer displayOrder;
    private boolean disabled;
    @OneToMany(mappedBy="category")
    private Set<Product> products;
}