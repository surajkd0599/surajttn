package com.example.project.ecommerce.services;

import com.example.project.ecommerce.model.User;
import com.example.project.ecommerce.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){userRepository.save(user);}
}
