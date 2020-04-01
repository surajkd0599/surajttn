package com.example.project.ecommerce.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "variation_Id")
    //private List<ProductVariation> productVariation;
    private ProductVariation productVariation;
}
