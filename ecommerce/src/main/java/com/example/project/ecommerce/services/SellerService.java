package com.example.project.ecommerce.services;

import com.example.project.ecommerce.model.ProductVariation;
import com.example.project.ecommerce.model.Seller;
import com.example.project.ecommerce.repos.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

}
