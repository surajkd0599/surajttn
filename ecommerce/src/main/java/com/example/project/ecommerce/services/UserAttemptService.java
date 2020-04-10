package com.example.project.ecommerce.services;

import com.example.project.ecommerce.model.User;
import com.example.project.ecommerce.model.UserAttempts;
import com.example.project.ecommerce.repos.UserAttemptRepo;
import com.example.project.ecommerce.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class UserAttemptService {

    public static final int MAX_ATTEMPT = 2;

    @Autowired
    private UserAttemptRepo userAttemptRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SendEmail sendEmail;

    @Transactional
    public void  userFailedAttempt(String username){

        UserAttempts userAttempt= userAttemptRepo.findByUsername(username);
        User user = userRepository.findByEmail(username);

        if (null != user){
            if(null != userAttempt){
                int attempt= userAttempt.getAttempts();
                if(attempt >= MAX_ATTEMPT){
                    userAttempt.setAttempts(attempt+1);
                    userAttempt.setLastModified(new Date());
                    userAttemptRepo.save(userAttempt);

                    user.setAccountNonLocked(false);
                    sendEmail.sendEmail("ACCOUNT LOCKED","You have done 3 unsuccessful attempts, hence your account is locked." +
                            "Sorry for the inconvenience. If you are a valid user then try to reset your password ." +
                            "\"To reset your password, please click here : http://localhost:8080/ecommerce/forgotPassword/token/"+username,user.getEmail());
                    userRepository.save(user);
                }else {
                    userAttempt.setAttempts(attempt+1);
                    userAttempt.setLastModified(new Date());
                    userAttemptRepo.save(userAttempt);
                }
            }else {
                UserAttempts userAttempts = new UserAttempts();
                userAttempts.setLastModified(new Date());
                userAttempts.setUsername(username);
                userAttempts.setAttempts(1);

                userAttemptRepo.save(userAttempts);
            }
        }
    }

    @Transactional
    public void  userSuccessAttempt(String username){
        UserAttempts userAttempt= userAttemptRepo.findByUsername(username);
        User user = userRepository.findByEmail(username);
        if(null != user){
            if(null != userAttempt){
                userAttemptRepo.deleteByUsername(username);
            }
        }
    }
}
