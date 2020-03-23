package com.example.project.ecommerce.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductVariation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long variationId;
    private String color;
    private String size;
    private Long price;
    private String gender;
    private int stock;

    public Long getVariationId() {
        return variationId;
    }

    public void setVariationId(Long variationId) {
        this.variationId = variationId;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "variation_Id",referencedColumnName = "variationId")
    private List<ProductReview> review;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "variation_Id",referencedColumnName = "variationId")
    private List<CartItem> cartItem;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "variation_id",referencedColumnName = "variationId")
    private List<OrderItem> orderItem;
    @ManyToOne
    private Product product;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ProductVariation() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
