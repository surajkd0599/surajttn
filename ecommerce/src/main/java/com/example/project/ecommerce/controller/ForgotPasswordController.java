package com.example.project.ecommerce.controller;

import com.example.project.ecommerce.services.ForgotPasswordService;
import com.example.project.ecommerce.validator.EmailValidation;
import com.example.project.ecommerce.validator.PasswordValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/ecommerce/forgotPassword")
public class ForgotPasswordController {

    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @Autowired
    private EmailValidation emailValidation;

    @Autowired
    private PasswordValidation passwordValidation;

    @PostMapping(path = "/token/{email}")
    public String sendToken(@PathVariable("email") String email){
        if (emailValidation.validateEmail(email)){
            return forgotPasswordService.sendToken(email);
        }else {
            return "Email is not valid";
        }
    }
    /*@PostMapping(path = "/token/{email}")
    public String sendToken(@PathVariable("email") String email){
        return forgotPasswordService.sendToken(email);
    }*/

    @PatchMapping("/reset-password")
    public String resetPassword(@RequestParam("token") String token, @RequestParam("email") String email, @RequestParam String pass, @RequestParam String cpass) {
        if(passwordValidation.validatePassword(pass,cpass)){
            return forgotPasswordService.resetPassword(email, token, pass, cpass);
        }else {
            return "Password is not valid. Password must be of minimum 8 characters and maximum 15 characters and must contain 1 uppercase letter,1 lowercase letter,1 digit and 1 special character";
        }
    }
}
