package com.example.project.ecommerce.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    private int quantity;
    private Long totalAmount;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id",referencedColumnName = "cartId")
    private CartItem cartItem;
}
