package com.leonardo.shoppingcart.controllers;

import com.leonardo.shoppingcart.entities.Category;
import com.leonardo.shoppingcart.entities.Product;
import com.leonardo.shoppingcart.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

public class HomeController extends SiteController
{
    @Autowired private CatalogService catalogService;

    @Override protected String getHeaderTitle()
    {
        return "Home";
    }

    @RequestMapping("/home")
    public String home(Model model)
    {
        List<Category> previewCategories = new ArrayList<>();
        List<Category> categories = catalogService.getAllCategories();
        for (Category category : categories)
        {
            Set<Product> products = category.getProducts();
            Set<Product> previewProducts = new HashSet<>();
            int noOfProductsToDisplay = 4;
            if(products.size() > noOfProductsToDisplay){
                Iterator<Product> iterator = products.iterator();
                for (int i = 0; i < noOfProductsToDisplay; i++)
                {
                    previewProducts.add(iterator.next());
                }
            } else {
                previewProducts.addAll(products);
            }
            category.setProducts(previewProducts);
            previewCategories.add(category);
        }
        model.addAttribute("categories", previewCategories);
        return "home";
    }
}
