package com.example.jpa3.jpa3;

import com.example.jpa3.jpa3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Jpa3Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext= SpringApplication.run(Jpa3Application.class, args);
		AuthorService authorService = applicationContext.getBean(AuthorService.class);

		//Add author
		//authorService.addAuthor();

	}

}
