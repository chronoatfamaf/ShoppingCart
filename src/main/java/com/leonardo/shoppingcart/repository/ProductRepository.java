package com.leonardo.shoppingcart.repository;

import com.leonardo.shoppingcart.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    Product findByName(String name);

    Product findByPcode(String sku);
    @Query("select p from Product p where p.name like ?1 or p.pcode like ?1")
    List<Product> search(String query);
}