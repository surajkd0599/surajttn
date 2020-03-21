package com.example.project.ecommerce.controller;

import com.example.project.ecommerce.model.User;
import com.example.project.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/rest/hello")
@RestController
public class AppController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/addUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }


}