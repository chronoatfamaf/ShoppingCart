package com.leonardo.shoppingcart.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="products")
public class Product implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(nullable=false, unique=true)
    private String pCode;

    @Column(nullable=false)
    private String name;
    private String description;

    @Column(nullable=false)
    private BigDecimal price = new BigDecimal("0.0");

    @ManyToOne
    @JoinColumn(name="cat_id")
    private Category category;

    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getPCode()
    {
        return pCode;
    }
    public void setPCode(String pCode)
    {
        this.pCode = pCode;
    }

    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public Category getCategory()
    {
        return category;
    }
    public void setCategory(Category category)
    {
        this.category = category;
    }
}
