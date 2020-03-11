package com.example.jpa.employee.employeejpa.employee.repos;

import com.example.jpa.employee.employeejpa.employee.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
/*(2) Set up EmployeeRepository with Spring Data JPA*/
/*
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}
*/
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer>{
    List<Employee> findByName(String name);
    List<Employee> findByAge(int age);
    List<Employee> findByLocation(String location);
    List<Employee> findByNameLike(String name);
    List<Employee> findByAgeBetween(int age1, int age2);
}