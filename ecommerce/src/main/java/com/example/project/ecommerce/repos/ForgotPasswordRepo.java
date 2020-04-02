package com.example.project.ecommerce.repos;

import com.example.project.ecommerce.model.ForgotPasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForgotPasswordRepo extends JpaRepository<ForgotPasswordToken,Long> {
    ForgotPasswordToken findByUserEmail(String email);
    void deleteByUserEmail(String email);
}
