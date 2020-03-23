package com.example.springsecurityoauth2.springsecurityoauth2.repos;

import com.example.springsecurityoauth2.springsecurityoauth2.model.GrantedAuthorityImpl;
import com.example.springsecurityoauth2.springsecurityoauth2.model.AppUser;
import com.example.springsecurityoauth2.springsecurityoauth2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class UserDao {
    @Autowired
    UserRepository userRepository;

    public AppUser loadUserByUsername(String username){
        User user = userRepository.findByUsername(username);
        System.out.println(user);
        if(username != null){
            return new AppUser(user.getUsername(),user.getPassword(), Arrays.asList(new GrantedAuthorityImpl(user.getRole())));
        }
        else {
            throw new RuntimeException();
        }
    }
}
