package com.leonardo.shoppingcart.service;

import com.leonardo.shoppingcart.entities.Product;
import com.leonardo.shoppingcart.repository.ProductRepository;
import com.leonardo.shoppingcart.security.SCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired ProductRepository productRepository;

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findOne(id);
    }

    public Product createProduct(Product product) { return productRepository.save(product); }

    public Product updateProduct(Product product)
    {
        Product persistedProduct = getProductById(product.getId());
        if(persistedProduct == null){ throw new SCException("Product "+product.getId()+" doesn't exist"); }
        persistedProduct.setPrice(product.getPrice());
        return productRepository.save(persistedProduct);
    }

    public List<Product> searchProducts(String query) {
        return productRepository.search("%"+query+"%");
    }
}