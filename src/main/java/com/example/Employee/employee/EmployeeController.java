package com.example.Employee.employee;

import com.example.Employee.employee.Exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDaoService service;

    @GetMapping(path = "/welcome")
    public String welcome(){
        return "Welcome to SpringBoot";
    }

    @GetMapping(path = "/retrieveEmployees")
    public List<Employee> retrieveEmployees(){
        return service.findAll();
    }


    @GetMapping(path = "/findEmployee/{id}")
    public Employee findEmployee(@PathVariable Integer id){
        Employee employeeById = service.findOne(id);
        if (employeeById == null) {
            throw new EmployeeNotFoundException("id-" + id) ;
        }
        return employeeById;
    }

    @PostMapping(path = "/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        Employee addEmp = service.employeeAdd(employee);
        return addEmp;
    }

    @DeleteMapping(path = "/deleteEmployee/{id}")
    public List<Employee> deleteEmployee(@PathVariable Integer id){
        return service.deleteEmployee(id);
    }

    @PutMapping("/updateEmployee")
    public List<Employee> updateEmployee(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

}
