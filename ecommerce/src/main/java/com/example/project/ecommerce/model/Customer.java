package com.example.project.ecommerce.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id",referencedColumnName = "customerId")
    private List<Cart> cart;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id",referencedColumnName = "customerId")
    private List<Orders> orders;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id",referencedColumnName = "customerId")
    private List<ProductReview> productReviews;

}
