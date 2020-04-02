package com.example.project.ecommerce.services;

import com.example.project.ecommerce.model.Customer;
import com.example.project.ecommerce.model.Seller;
import com.example.project.ecommerce.model.User;
import com.example.project.ecommerce.repos.CustomerRepository;
import com.example.project.ecommerce.repos.SellerRepository;
import com.example.project.ecommerce.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private UserRepository  userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private SendEmail sendEmail;

    public List<Customer> registeredCustomers(String page,String size, String SortBy){
        return customerRepository.findAll(PageRequest.of(Integer.parseInt(page),Integer.parseInt(size), Sort.by(SortBy))).getContent();
    }

    public List<Seller> registeredSellers(String page,String size, String SortBy){
        return sellerRepository.findAll(PageRequest.of(Integer.parseInt(page),Integer.parseInt(size), Sort.by(SortBy))).getContent();
    }

    public String activateUser(Long userId){
        Optional<User> user = userRepository.findById(userId);
        StringBuilder sb = new StringBuilder();

        if(user.isPresent()){
            boolean flag = user.get().isActive();
            if(!flag){
                user.get().setActive(true);
                userRepository.save(user.get());
                sendEmail.sendEmail("Account Activation","Your account is successfully activated",
                        user.get().getEmail());
                sb.append("Account activated");
            }else {
                sb.append("User is already activated");
            }
        }else {
            sb.append("User not found");
        }
        return sb.toString();
    }

    public String deactivateUser(Long userId){
        Optional<User> user = userRepository.findById(userId);
        StringBuilder sb = new StringBuilder();

        if(user.isPresent()){
            boolean flag = user.get().isActive();
            if(flag){
                user.get().setActive(false);
                userRepository.save(user.get());
                sendEmail.sendEmail("Account De-Activation","Your account is successfully de-activated",
                        user.get().getEmail());
                sb.append("Account de-activated");
            }else {
                sb.append("User is already de-activated");
            }
        }else {
            sb.append("User not found");
        }
        return sb.toString();
    }
}
