package com.example.project.ecommerce;

import com.example.project.ecommerce.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(EcommerceApplication.class, args);

	}

}
