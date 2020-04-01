package com.example.project.ecommerce.services;

import com.example.project.ecommerce.dao.UserDao;
import com.example.project.ecommerce.model.Customer;
import com.example.project.ecommerce.model.VerificationToken;
import com.example.project.ecommerce.model.Seller;
import com.example.project.ecommerce.model.User;
import com.example.project.ecommerce.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private CustomerActivateRepo customerActivateRepo;

    @Autowired
    private SendEmail sendEmail;

    public String registerCustomer(Customer customer){
        customerRepository.save(customer);

        String token = UUID.randomUUID().toString();

        VerificationToken customerActivate = new VerificationToken();
        customerActivate.setToken(token);
        customerActivate.setUserEmail(customer.getEmail());
        customerActivate.setGeneratedDate(new Date());

        customerActivateRepo.save(customerActivate);

        sendEmail.sendEmail("ACCOUNT ACTIVATE TOKEN","To confirm your account, please click here : "
                +"http://localhost:8080/ecommerce/register/confirm-account?token="+token,customer.getEmail());

        return "Registration Successful";
    }

    public User registerSeller(Seller seller){
        return sellerRepository.save(seller);
    }

    public User registerAdmin(User admin){
        return userRepository.save(admin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String encryptedPassword = passwordEncoder.encode("pass");
        System.out.println("Username to be authenticated : "+username);
        System.out.println("Encoded password : "+encryptedPassword);
        UserDetails userDetails = userDao.loadUserByUsername(username);
        return userDetails;
    }

    @Transactional
    @Modifying
    public void updateUserUsername(String username,String userName){
        Long userId = userRepository.findUserId(username);
        userRepository.updateUserUsername(userId,userName);
    }

    @Transactional
    @Modifying
    public void updateUserFirstName(String username,String firstName){
        Long userId = userRepository.findUserId(username);
        userRepository.updateUserFirstName(userId,firstName);
    }

    @Transactional
    @Modifying
    public void updateUserLastName(String username,String lastName){
        Long userId = userRepository.findUserId(username);
        userRepository.updateUserLastName(userId,lastName);
    }

    @Transactional
    @Modifying
    public void updateUserEmail(String username,String email){
        Long userId = userRepository.findUserId(username);
        userRepository.updateUserEmail(userId,email);
    }

    @Transactional
    @Modifying
    public void updateUserPassword(String username,String password){
        Long userId = userRepository.findUserId(username);
        userRepository.updateUserPassword(userId,password);
    }
}
