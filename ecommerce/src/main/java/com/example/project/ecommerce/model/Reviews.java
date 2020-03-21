package com.example.project.ecommerce.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private String comment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "userId")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id",referencedColumnName = "productId")
    private Product product;
    @Temporal(TemporalType.DATE)
    private Date reviewCreatedAt;
    @Temporal(TemporalType.DATE)
    private Date reviewModifiedAt;
}
