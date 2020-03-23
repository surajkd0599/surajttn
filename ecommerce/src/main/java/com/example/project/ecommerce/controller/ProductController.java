package com.example.project.ecommerce.controller;

import com.example.project.ecommerce.model.Product;
import com.example.project.ecommerce.model.ProductCategory;
import com.example.project.ecommerce.model.ProductVariation;
import com.example.project.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/addCategory")
    public ProductCategory addProduct(@RequestBody ProductCategory productCategory) {
        return productService.addCategory(productCategory);
    }

    @GetMapping(path = "/getCategory")
    public List<Object[]> getCategry() {
        return productService.getCategory();
    }

    @GetMapping(path = "/getProduct/{categoryName}")
    public List<Object[]> getProduct(@PathVariable(value = "categoryName") String categoryName) {
        return productService.getProduct(categoryName);
    }

    @GetMapping(path = "/getVariation/{productName}")
    public List<Object[]> getVariation(@PathVariable(value = "productName") String productName) {
        return productService.getVariation(productName);
    }

    @GetMapping(path = "/getVariation/priceLowToHigh/{productName}")
    public List<Object[]> priceLowToHigh(@PathVariable(value = "productName") String productName) {
        return productService.priceLowToHigh(productName);
    }

    @GetMapping(path = "/getVariation/priceHighToLow/{productName}")
    public List<Object[]> priceHighToLow(@PathVariable(value = "productName") String productName) {
        return productService.priceHighToLow(productName);
    }

    @PutMapping(path = "/updateStockInProduct/{productName}" )
    public void updateStockByAdmin(@PathVariable(value = "productName")String productName,@RequestBody ProductVariation productVariation)
            {

    }
}
