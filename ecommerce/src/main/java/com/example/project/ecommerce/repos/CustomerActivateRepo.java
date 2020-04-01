package com.example.project.ecommerce.repos;

import com.example.project.ecommerce.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerActivateRepo extends JpaRepository<VerificationToken,Long> {
    VerificationToken findByUserEmail(String email);
    void deleteByUserEmail(String email);
    VerificationToken findByToken(String token);

}
