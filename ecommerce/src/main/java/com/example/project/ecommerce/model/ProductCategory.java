package com.example.project.ecommerce.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(unique = true)
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id",referencedColumnName = "categoryId")
    private List<Product> product;

    public ProductCategory() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
