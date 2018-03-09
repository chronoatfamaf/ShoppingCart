package com.leonardo.shoppingcart.service;

import com.leonardo.shoppingcart.entities.Category;
import com.leonardo.shoppingcart.entities.Product;
import com.leonardo.shoppingcart.repository.ProductRepository;
import com.leonardo.shoppingcart.repository.CategoryRepository;
import com.leonardo.shoppingcart.security.SCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CatalogService
{
    @Autowired CategoryRepository categoryRepository;
    @Autowired ProductRepository productRepository;

    public List<Category> getAllCategories() { return categoryRepository.findAll(); }

    public Category getCategoryByName(String name) {
        return categoryRepository.getByName(name);
    }

    public Product getProductByPCode(String cod) {
        return productRepository.findByCod(cod);
    }

    public List<Product> searchProducts(String query) { return productRepository.search("%"+query+"%"); }
}