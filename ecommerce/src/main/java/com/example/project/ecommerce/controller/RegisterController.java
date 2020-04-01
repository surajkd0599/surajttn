package com.example.project.ecommerce.controller;

import com.example.project.ecommerce.model.Customer;
import com.example.project.ecommerce.model.Seller;
import com.example.project.ecommerce.model.User;
import com.example.project.ecommerce.services.AppUserDetailsService;
import com.example.project.ecommerce.services.CustomerActivateService;
import com.example.project.ecommerce.services.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "/ecommerce/register")
public class RegisterController {

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Autowired
    private CustomerActivateService customerActivateService;

    @Autowired
    SendEmail sendEmail;

    @PostMapping(path = "/customer")
    public String registerCustomer(@Valid @RequestBody Customer customer){

        String getMessage = appUserDetailsService.registerCustomer(customer);
        return getMessage;
    }

    @GetMapping(path = "/confirm-account")
    public String confirmCustomerAccount(@RequestParam("token") String token){
        return customerActivateService.activateCustomer(token);
    }

    @GetMapping("/sendemail")
    public void sendEmail(){
        sendEmail.sendEmail("RE-ACCOUNT ACTIVATE TOKEN","12356gh","manoj260191@gmail.com");
    }

    @PostMapping(path = "/seller")
    public User registerSeller(@Valid @RequestBody Seller seller){

        User user = appUserDetailsService.registerSeller(seller);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getUserId()).toUri();
        ResponseEntity.created(location).build();

        return user;
    }

    @PostMapping(path = "/admin")
    public User registerAdmin(@Valid @RequestBody User admin){

        User user = appUserDetailsService.registerAdmin(admin);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getUserId()).toUri();
        ResponseEntity.created(location).build();

        return user;
    }
}
