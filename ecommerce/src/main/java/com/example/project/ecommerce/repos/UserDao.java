package com.example.project.ecommerce.repos;

import com.example.project.ecommerce.model.AppUser;
import com.example.project.ecommerce.model.GrantedAuthorityImpl;
import com.example.project.ecommerce.model.Role;
import com.example.project.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    UserRepository userRepository;

    public AppUser loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        List<GrantedAuthorityImpl> grantedAuthorityImpl = new ArrayList<>();
        System.out.println(user);
        if (username != null) {
            for (Role auth : user.getRoles()) {
                grantedAuthorityImpl.add(new GrantedAuthorityImpl(auth.getRole()));
            }
            System.out.println(grantedAuthorityImpl);
            return new AppUser(user.getUsername(), user.getPassword(),
                    grantedAuthorityImpl);
        }
        else {
            throw new UsernameNotFoundException("Username not found");
        }

    }
}
