package com.example.project.ecommerce.controller;

import com.example.project.ecommerce.dtos.CustomerDto;
import com.example.project.ecommerce.dtos.SellerDto;
import com.example.project.ecommerce.model.Admin;
import com.example.project.ecommerce.model.Customer;
import com.example.project.ecommerce.model.Seller;
import com.example.project.ecommerce.model.User;
import com.example.project.ecommerce.services.AppUserDetailsService;
import com.example.project.ecommerce.services.CustomerActivateService;
import com.example.project.ecommerce.services.DtoService;
import com.example.project.ecommerce.services.SendEmail;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/ecommerce/register")
public class RegisterController {

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Autowired
    private CustomerActivateService customerActivateService;

    @Autowired
    private DtoService dtoService;

    @PostMapping(path = "/customer")
    public String registerCustomer(@Valid @RequestBody CustomerDto customerDto,HttpServletResponse response){
        if(dtoService.validateCustomer(customerDto).equals("validated")) {
             response.setStatus(HttpServletResponse.SC_CREATED);
             return appUserDetailsService.registerCustomer(customerDto);

        }else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return dtoService.validateCustomer(customerDto);
        }
    }

    @PostMapping(path = "/seller")
    public String registerSeller(@Valid @RequestBody SellerDto sellerDto,HttpServletResponse response){
        if(dtoService.validateSeller(sellerDto).equals("validated")) {
            response.setStatus(HttpServletResponse.SC_CREATED);
            return appUserDetailsService.registerSeller(sellerDto);
        }else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return dtoService.validateSeller(sellerDto);
        }
    }

    @PutMapping(path = "/confirm-account")
    public String confirmCustomerAccount(@RequestParam("token") String token, HttpServletResponse response){
        String message = customerActivateService.activateCustomer(token);
        if(!message.equals("Successfully activated")){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return message;
    }

    @PostMapping(path = "/resend-activation")
    public String resendLink(@RequestParam("email") String email,HttpServletResponse response){
        String message = customerActivateService.resendLink(email);
        if(!message.equals("Successful")){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return message;
    }

    @PostMapping(path = "/admin")
    public User registerAdmin(@Valid @RequestBody Admin admin){

        User user = appUserDetailsService.registerAdmin(admin);

        return user;
    }
}
