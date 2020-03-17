package com.example.jpa3.jpa3.services;

import com.example.jpa3.jpa3.entities.Address;
import com.example.jpa3.jpa3.entities.Author;
import com.example.jpa3.jpa3.entities.Subjects;
import com.example.jpa3.jpa3.repos.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public void addAuthor(){
        Author author = new Author();
        author.setFirstName("Suraj");
        author.setLastName("Dubey");
        author.setAddress(new Address(11,"vijay nagar","ghaziabad"));
        Subjects s1 = new Subjects();
        s1.setSubjectName("Arts");
        Subjects s2 = new Subjects();
        s2.setSubjectName("Maths");
        Subjects s3 = new Subjects();
        s3.setSubjectName("Hindi");

        author.addSubjects(s1);
        author.addSubjects(s2);
        author.addSubjects(s3);

        authorRepository.save(author);
    }
}
