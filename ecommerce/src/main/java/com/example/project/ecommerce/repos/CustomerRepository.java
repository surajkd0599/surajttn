package com.example.project.ecommerce.repos;

import com.example.project.ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //List<Customer> findAll(Pageable pageable);
}
