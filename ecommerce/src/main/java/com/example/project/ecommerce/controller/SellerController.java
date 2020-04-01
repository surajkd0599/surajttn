package com.example.project.ecommerce.controller;

import com.example.project.ecommerce.model.ProductCategory;
import com.example.project.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ecommerce/seller/home")
public class SellerController {

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
}
