package com.leonardo.shoppingcart.repository;

import com.leonardo.shoppingcart.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>
{
    Category getByName(String name);
}
