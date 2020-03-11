package com.example.jpa.employee.employeejpa.employee.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
(1) Create an Employee Entity which contains following fields

        Name

        Id

        Age

        Location*/
@Entity
@Table(name = "employee")
public class Employee {

    String name;
    @Id
    int id;
    int age;
    String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
