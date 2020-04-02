package com.example.project.ecommerce.controller;

import com.example.project.ecommerce.services.ForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/ecommerce/forgotPassword")
public class ForgotPasswordController {

    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @Autowired
    private TokenStore tokenStore;

    @PostMapping(path = "/token/{email}")
    public String sendToken(@PathVariable String email){
        return forgotPasswordService.sendToken(email);
    }

    @PatchMapping("/reset-password")
    public String resetPassword(@RequestParam("token") String token, @RequestParam("email") String email, @RequestParam String pass, @RequestParam String cpass) {
        return forgotPasswordService.resetPassword(email, token, pass, cpass);
    }
}
