package com.example.project.ecommerce.dao;

import com.example.project.ecommerce.model.Customer;
import com.example.project.ecommerce.model.Seller;


public class UserRegisterVo {
    private Customer customer;
    private Seller seller;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
