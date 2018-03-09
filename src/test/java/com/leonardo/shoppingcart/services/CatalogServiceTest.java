package com.leonardo.shoppingcart.services;

import com.leonardo.shoppingcart.entities.Category;
import com.leonardo.shoppingcart.entities.Product;
import com.leonardo.shoppingcart.repository.CategoryRepository;
import com.leonardo.shoppingcart.repository.ProductRepository;
import com.leonardo.shoppingcart.service.CatalogService;

import com.leonardo.shoppingcart.utils.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class CatalogServiceTest {

    @Mock
    private ProductRepository mockProductRepository;

    @Mock
    private CategoryRepository mockCategoryRepository;

    @InjectMocks
    private CatalogService catalogService;

    private Category category_1;
    private Category category_2;
    private Product product_1;
    private Product product_2;

    @Before
    public void create() {
        initMocks(CatalogServiceTest.class);
        category_1 = EntityUtils.createDummyCategory(1, "category_1", 1);
        category_2 = EntityUtils.createDummyCategory(2, "category_2", 2);
        product_1 = EntityUtils.createDummyProduct(1,"P2001", category_1);
        product_2 = EntityUtils.createDummyProduct(2,"P2002", category_1 );
    }

    @Test
    public void getCategoryByNameTest() {
        when(mockCategoryRepository.getByName("category_1")).thenReturn(category_1);
        verify(mockCategoryRepository,times(1)).getByName("category_1");
        assertEquals(category_1, catalogService.getCategoryByName("category_1"));
    }

    @Test
    public void getAllCategoriesTest() {
        List<Category> category_list = new ArrayList<>();
        category_list.add(category_1);
        category_list.add(category_2);

        when(mockCategoryRepository.findAll()).thenReturn(category_list);
        List<Category> categories_all = catalogService.getAllCategories();
        verify(mockCategoryRepository,times(1)).findAll();

        assertFalse(catalogService.getAllCategories().isEmpty());
        assertEquals(category_list,categories_all);
    }

    @Test
    public void getProductByCodeTest() {
        String query = "P2001";
        when(mockProductRepository.findByCod(query)).thenReturn(product_1);
        Product foundProduct = catalogService.getProductByPCode(query);
        verify(mockProductRepository,times(1)).findByCod(query);
        assertEquals(product_1, foundProduct);
    }

    @Test
    public void searchProductsTest() {
        String query = "P200";
        List<Product> productsList = new ArrayList<>();
        productsList.add(product_1);
        productsList.add(product_2);
        when(mockProductRepository.search("%"+query+"%")).thenReturn(productsList);
        List<Product> productsSearch = catalogService.searchProducts(query);
        verify(mockProductRepository, times(1)).search("%"+query+"%");
        assertFalse(productsSearch.isEmpty());
        assertEquals(productsList, productsSearch);
    }
}
