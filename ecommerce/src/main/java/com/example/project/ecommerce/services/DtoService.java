package com.example.project.ecommerce.services;

import com.example.project.ecommerce.dtos.CustomerDto;
import com.example.project.ecommerce.dtos.SellerDto;
import com.example.project.ecommerce.model.Seller;
import com.example.project.ecommerce.model.User;
import com.example.project.ecommerce.repos.SellerRepository;
import com.example.project.ecommerce.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SellerRepository sellerRepository;

    public String validateCustomer(CustomerDto customerDto){
        String str = "validated";
        User user = userRepository.findByEmail(customerDto.getEmail());
        System.out.println("user object "+user);
        if (null!=user){
           str = "Email already exist";
        }else if(!customerDto.getPassword().equals(customerDto.getConfirmPassword())){
            str="Passswords not matched";
        }
        return str;
    }

    public String validateSeller(SellerDto sellerDto){
        String str = "validated";
        User user = userRepository.findByEmail(sellerDto.getEmail());
        Seller seller = sellerRepository.findByGst(sellerDto.getGst());
        if (null!=user){
            str = "Email already exist";
        }else if(!sellerDto.getPassword().equals(sellerDto.getConfirmPassword())){
            str = "Passwords not matched";
        }else if(null!=seller){
            str = "Gst numer already exist";
        }
        return str;
    }
}
