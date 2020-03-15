package com.example.jpql.employee.jpqlemployee.services;

import com.example.jpql.employee.jpqlemployee.entities.Employee;
import com.example.jpql.employee.jpqlemployee.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void addEmployee(){
        employeeRepository.save(new Employee("Saurav","Singh",18100,46));
    }

    public void findNamesBySalary(){
        List<Object[]> employeeBySalary = employeeRepository.findBySalary();
        for (Object[] objects : employeeBySalary){
            System.out.println(objects[0]+" "+objects[1]);
        }
    }

    public void updateSalary(){
        int avgSalary = employeeRepository.averageSalary();
        employeeRepository.updateSalary(avgSalary,10000);
        System.out.println(employeeRepository.findAll());
    }

    public void deleteEmployee(){
        int minSalary = employeeRepository.minimumSalary();
        employeeRepository.deleteEmployee(minSalary);
        System.out.println(employeeRepository.findAll());
    }

    public void getEmployeeSingh(){
        List<Object[]> employeeSingh = employeeRepository.employeeSingh();
        for (Object[] o:employeeSingh){
            System.out.println(o[0]+" "+o[1]+" "+o[2]);
        }
    }

    public void deleteEmployeeGreater(){
        employeeRepository.deleteEmployeeByGreaterAge();
    }
}
