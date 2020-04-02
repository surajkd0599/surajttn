package com.example.project.ecommerce.services;

import com.example.project.ecommerce.model.ForgotPasswordToken;
import com.example.project.ecommerce.model.User;
import com.example.project.ecommerce.repos.ForgotPasswordRepo;
import com.example.project.ecommerce.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
public class ForgotPasswordService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ForgotPasswordRepo forgotPasswordRepo;

    @Autowired
    private SendEmail sendEmail;

    @Autowired
    private TokenStore tokenStore;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String sendToken(String email){
        StringBuilder sb = new StringBuilder();
        User user = userRepository.findByEmail(email);
        ForgotPasswordToken existingUser = forgotPasswordRepo.findByUserEmail(email);
        try {
            if(!user.equals(null)){
                if(!existingUser.equals(null)){
                    forgotPasswordRepo.deleteByUserEmail(email);
                }
                String token = UUID.randomUUID().toString();

                ForgotPasswordToken forgotPasswordToken = new ForgotPasswordToken();
                forgotPasswordToken.setGeneratedDate(new Date());
                forgotPasswordToken.setToken(token);
                forgotPasswordToken.setUserEmail(email);

                forgotPasswordRepo.save(forgotPasswordToken);

                sendEmail.sendEmail("Reset your password","To reset your password, please click here : "
                        +"http://localhost:8080/reset-password?token="+token+"&email="+email,email);

                sb.append("Change your password");
            }
        } catch (NullPointerException ex){
            sb.append("No email found");
        }
        return sb.toString();
    }

    @Transactional
    public String resetPassword(String email,String token,String password,String confirmPassword){

        ForgotPasswordToken userData = forgotPasswordRepo.findByUserEmail(email);
        StringBuilder sb = new StringBuilder();
        User user = null;

        if (null!=userData){
            if(userData.getToken().equals(token)){
               if(password.equals(confirmPassword)){
                   boolean flag = isTokenExpired(email,userData);
                   if(!flag){
                       user = userRepository.findByEmail(userData.getUserEmail());
                       user.setPassword(passwordEncoder.encode(password));
                       userRepository.save(user);
                       forgotPasswordRepo.deleteByUserEmail(email);

                       sendEmail.sendEmail("Password Changed","Your password has been changed",email);

                       sb.append("Password successfully changed.");
                   }else {
                       sb.append("Password not updated as token expired");
                   }
               }else {
                   sb.append("Password not matched");
               }
            }else {
                sb.append("Invalid Token");
            }
        }else {
            sb.append("User not found");
        }
        return sb.toString();
    }

    boolean isTokenExpired(String email,ForgotPasswordToken userData){

        Date date = new Date();
        long diff = date.getTime() - userData.getGeneratedDate().getTime();
        long diffHours = diff / (60 * 60 * 1000);

        boolean flag = false;
        if (diffHours > 24) {
            forgotPasswordRepo.deleteByUserEmail(email);
            flag=true;
        }
        return flag;
    }
}
