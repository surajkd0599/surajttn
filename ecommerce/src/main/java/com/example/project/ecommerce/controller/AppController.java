package com.example.project.ecommerce.controller;

import com.example.project.ecommerce.model.User;
import com.example.project.ecommerce.services.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RequestMapping("/ecommerce")
@RestController
public class AppController {

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Autowired
    ProductController productController;

    @Autowired
    private TokenStore tokenStore;

    @PostMapping(path = "/addUser")
    public void addUser(@RequestBody User user){
        appUserDetailsService.addUser(user);
    }

    @GetMapping("/doLogout")
    public String logout(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            String tokenValue = authHeader.replace("Bearer", "").trim();
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
            tokenStore.removeAccessToken(accessToken);
        }
        return "Logged out successfully";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/admin/home")
    public String adminHome(){
        return "Admin home";
    }

    @GetMapping("/seller/home")
    public String sellerHome(){
        return "Seller home";
    }

    @GetMapping("/user/home")
    public String userHome(){
        return "User home";
    }


}