package com.example.Employee.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDaoService {
    private static List<Employee> employeeList = new ArrayList<>();
    private static int countEmployees = 2;

    static{
        employeeList.add(new Employee(1,"Suraj",21));
        employeeList.add(new Employee(2,"Vishal",22));
    }

    public List<Employee> findAll(){
        return employeeList;
    }

    public Employee employeeAdd(Employee employee){
        if(employee.getId() == null){
            employee.setId(++countEmployees);
        }
        employeeList.add(employee);
        return employee;
    }

    public Employee findOne(int id){
        for(Employee employee : employeeList){
            if(employee.getId() == id){
                return employee;
            }
        }
        return null;
    }

    /*public List<Employee> deleteEmployee(Integer id){
        if(employeeList.contains(id)){
            employeeList.remove(id);
            return (List<Employee>) employeeList;
        }
        return null;
    }*/

    public List<Employee> deleteEmployee(Integer id){
        Iterator iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee employee = (Employee) iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                return employeeList;
            }
        }
        return null;
    }

    public List<Employee> updateEmployee(Employee employee) {
        Iterator iterator = employeeList.iterator();
        Employee employeeLocal = (Employee) iterator.next();
        while (iterator.hasNext()) {
            if (employee.getId() == employeeLocal.getId()) {
                employeeList.remove(employeeLocal);
            }
        }
        employeeList.add(employee);
        return employeeList;
    }


}
