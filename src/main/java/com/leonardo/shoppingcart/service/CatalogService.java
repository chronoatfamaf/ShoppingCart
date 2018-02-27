package com.leonardo.shoppingcart.service;

import com.leonardo.shoppingcart.entities.Category;
import com.leonardo.shoppingcart.entities.Product;
import com.leonardo.shoppingcart.repository.ProductRepository;
import com.leonardo.shoppingcart.repository.CatalogRepository;
import com.leonardo.shoppingcart.security.SCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CatalogService {
    @Autowired CatalogRepository catalogRepository;
    @Autowired ProductRepository productRepository;

    public List<Category> getAllCategories() { return catalogRepository.findAll(); }

    public List<Product> getAllProducts() { return productRepository.findAll(); }

    public Category getCategoryByName(String name) {
        return catalogRepository.getByName(name);
    }

    public Category getCategoryById(Integer id) {
        return catalogRepository.findOne(id);
    }

    public Category createCategory(Category category)
    {
        Category persistedCategory = getCategoryByName(category.getName());
        if(persistedCategory != null)
        {
            throw new SCException("Category "+category.getName()+" already exist");
        }
        return catalogRepository.save(category);
    }

    public Category updateCategory(Category category) {
        Category persistedCategory = getCategoryById(category.getId());
        if(persistedCategory == null){
            throw new SCException("Category "+category.getId()+" doesn't exist");
        }
        persistedCategory.setDescription(category.getDescription());
        persistedCategory.setDisplayOrder(category.getDisplayOrder());
        persistedCategory.setDisabled(category.isDisabled());
        return catalogRepository.save(persistedCategory);
    }

    public Product getProductById(Integer id) {
        return productRepository.findOne(id);
    }

    public Product getProductByPcode(String pcode) {
        return productRepository.findByPcode(pcode);
    }

    public Product createProduct(Product product)
    {
        Product persistedProduct = getProductByPcode(product.getName());
        if(persistedProduct != null)
        {
            throw new SCException("Product SKU "+product.getPcode()+" already exist");
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Product product)
    {
        Product persistedProduct = getProductById(product.getId());
        if(persistedProduct == null)
        {
            throw new SCException("Product "+product.getId()+" doesn't exist");
        }
        persistedProduct.setPrice(product.getPrice());
        persistedProduct.setCategory(getCategoryById(product.getCategory().getId()));
        return productRepository.save(persistedProduct);
    }

    public List<Product> searchProducts(String query) {
        return productRepository.search("%"+query+"%");
    }

}