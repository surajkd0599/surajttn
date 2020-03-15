package com.example.jpql.employee.jpqlemployee;

import com.example.jpql.employee.jpqlemployee.services.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JpqlemployeeApplication {
	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(JpqlemployeeApplication.class, args);
		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);

		//employeeService.addEmployee();
		/*JPQL*/
		//System.out.println(employeeRepository.findAllEmployee());

		/*Q1 Display the first name, last name of all employees having salary greater than average salary ordered in
		 ascending by their age and in descending by their salary.*/
		employeeService.findNamesBySalary();

		/*Q2 Update salary of all employees by a salary passed as a parameter whose existing salary is less
		than the average salary.*/
		employeeService.updateSalary();

		//Q3 Delete all employees with minimum salary.
		employeeService.deleteEmployee();

		/*Native SQL Query:*/

		//Q1 Display the id, first name, age of all employees where last name ends with "singh"
		employeeService.getEmployeeSingh();

		//Q2 Delete all employees with age greater than 45(Should be passed as a parameter)
		employeeService.deleteEmployeeGreater();
	}

}
