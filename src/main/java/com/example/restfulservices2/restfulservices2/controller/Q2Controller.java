package com.example.restfulservices2.restfulservices2.controller;

import com.example.restfulservices2.restfulservices2.model.User;
import com.example.restfulservices2.restfulservices2.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/q2")
public class Q2Controller {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/adduser")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping(path = "/getuser")
    public List<User> getUser(){
        return userService.getAll();
    }




}
