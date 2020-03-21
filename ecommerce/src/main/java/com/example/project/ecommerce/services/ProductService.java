package com.example.project.ecommerce.services;

import com.example.project.ecommerce.model.Product;
import com.example.project.ecommerce.model.ProductCategory;
import com.example.project.ecommerce.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product){productRepository.save(product);}

    public List<Object[]> getProduct(){
       return productRepository.findProduct();
    }

    public List<Object[]> getCategory(String productName){
        Long productId = productRepository.productId(productName);
        return productRepository.findCategory(productId);
    }

    public List<Object[]> getVariation(String categoryName) {
        Long categoryId = productRepository.categoryId(categoryName);
        return productRepository.findVariation(categoryId);
    }

    public List<Object[]> priceLowToHigh(String categoryName){
        Long categoryId = productRepository.categoryId(categoryName);
        return productRepository.priceLowToHigh(categoryId);
    }

    public List<Object[]> priceHighToLow(String categoryName){
        Long categoryId = productRepository.categoryId(categoryName);
        return productRepository.priceHighToLow(categoryId);
    }
}
