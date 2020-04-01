package com.example.project.ecommerce.repos;

import com.example.project.ecommerce.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface SellerRepository extends JpaRepository<Seller,Long> {
   // List<Seller> findAll(Pageable pageable);
}
