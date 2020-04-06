package com.example.project.ecommerce.controller;

import com.example.project.ecommerce.model.Cart;
import com.example.project.ecommerce.model.Product;
import com.example.project.ecommerce.services.CustomerService;
import com.example.project.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ecommerce/user/home")
public class CustomerController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

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

    @PostMapping(path = "/addToCart")
    public Cart addToCart(@RequestBody Cart cart){
        return customerService.addToCart(cart);
    }
}
