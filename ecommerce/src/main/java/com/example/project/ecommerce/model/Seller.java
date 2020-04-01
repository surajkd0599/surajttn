package com.example.project.ecommerce.model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Seller extends User{

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;*/

    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
