package com.example.project.ecommerce.controller;

import com.example.project.ecommerce.model.Product;
import com.example.project.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/addProduct")
    public void addProduct(@RequestBody Product product){productService.addProduct(product);}

    @GetMapping(path = "/getProduct")
    public List<Object[]> getProduct(){
        return productService.getProduct();
    }

    @GetMapping(path = "/getCategory/{productName}")
    public List<Object[]> getCategory(@PathVariable(value = "productName") String productName)
    {
        return productService.getCategory(productName);
    }

    @GetMapping(path = "/getVariation/{categoryName}")
    public List<Object[]> getVariation(@PathVariable(value = "categoryName") String categoryName)
    {
        return productService.getVariation(categoryName);
    }

    @GetMapping(path = "/getVariation/priceLowToHigh/{categoryName}")
    public List<Object[]> priceLowToHigh(@PathVariable(value = "categoryName") String categoryName)
    {
        return productService.priceLowToHigh(categoryName);
    }

    @GetMapping(path = "/getVariation/priceHighToLow/{categoryName}")
    public List<Object[]> priceHighToLow(@PathVariable(value = "categoryName") String categoryName)
    {
        return productService.priceHighToLow(categoryName);
    }
}
