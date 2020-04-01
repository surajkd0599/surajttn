package com.example.project.ecommerce.controller;

import com.example.project.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ecommerce/user/home")
public class CustomerController {

    @Autowired
    private ProductService productService;

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
}
