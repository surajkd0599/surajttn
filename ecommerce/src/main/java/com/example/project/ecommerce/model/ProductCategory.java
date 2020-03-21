package com.example.project.ecommerce.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id",referencedColumnName = "categoryId")
    private List<ProductVariation> productVariation;

    public ProductCategory() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductVariation> getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(List<ProductVariation> productVariation) {
        this.productVariation = productVariation;
    }
}
