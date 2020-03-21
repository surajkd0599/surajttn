package com.example.project.ecommerce.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Temporal(TemporalType.DATE)
    private Date orderPlacedDate;
    @Temporal(TemporalType.DATE)
    private Date orderReceivedDate;
    private String orderStatus;
    private int orderPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "userId")
    private User user;
}
