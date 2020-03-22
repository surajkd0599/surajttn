package com.example.project.ecommerce.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private String comment;
    @Temporal(TemporalType.DATE)
    private Date reviewCreatedAt;
    @Temporal(TemporalType.DATE)
    private Date reviewModifiedAt;
}
