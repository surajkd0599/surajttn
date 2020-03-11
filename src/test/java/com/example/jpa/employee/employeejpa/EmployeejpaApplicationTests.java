package com.example.jpa.employee.employeejpa;

import com.example.jpa.employee.employeejpa.employee.entities.Employee;
import com.example.jpa.employee.employeejpa.employee.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EmployeejpaApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}
//	(3) Perform Create Operation on Entity using Spring Data JPA
//
	@Test
	public void testCreateEmployee(){
		Employee employee = new Employee();
		employee.setId(2);
		employee.setAge(30);
		employee.setName("Hanish");
		employee.setLocation("New Delhi");
		employeeRepository.save(employee);
	}
	//			(4) Perform Update Operation on Entity using Spring Data JPA
//
	@Test
	public void testUpdateEmployee(){
		Optional<Employee> employee = employeeRepository.findById(1);
		employee.get().setAge(21);
		employeeRepository.save(employee.get());
	}
	//(5) Perform Delete Operation on Entity using Spring Data JPA
//
	@Test
	public void testDeleteEmployee(){
		if(employeeRepository.existsById(2)){
			employeeRepository.deleteById(2);
		}
	}

	//(5) Perform Read Operation on Entity using Spring Data JPA
//
	@Test
	public void testReadEmployee(){
		Optional<Employee> employee = employeeRepository.findById(3);
		assertNotNull(employee);
		assertEquals(25,employee.get().getAge());
		System.out.println("Name of employee is : "+employee.get().getName());
	}
	//(6) Get the total count of the number of Employees
//
	@Test
	public void testCountEmployee(){
		System.out.println("Number of employees in records are : "+employeeRepository.count());
	}
	//			(7) Implement Pagination and Sorting on the bases of Employee Age
//
	@Test
	public void testPagingAndSortingEmployee(){
		Pageable pageable = PageRequest.of(0,5, Sort.Direction.ASC,"age");
		employeeRepository.findAll(pageable).forEach(p-> System.out.println(p.getName()));
	}
	//(8) Create and use finder to find Employee by Name
//
	@Test
	public void testFindByName(){
		List<Employee> employeeList = employeeRepository.findByName("Shyam");
		employeeList.forEach(p-> System.out.println(p.getId()+" " + p.getAge()
				+" "+ p.getName() +" "+ p.getLocation() ));
	}
	//			(9) Create and use finder to find Employees starting with A character
//
	@Test
	public void testFindByNameLike(){
		List<Employee> employeeList = employeeRepository.findByNameLike("A%");
		employeeList.forEach(p -> System.out.println(p.getId()+" "+p.getAge()+
				" "+p.getName()+" "+p.getLocation()));
	}
	//(10) Create and use finder to find Employees Between the age of 28 to 32
	@Test
	public void testFindByAgeBetween(){
		List<Employee> employeeList = employeeRepository.findByAgeBetween(28,32);
		employeeList.forEach(p -> System.out.println(p.getId()+" "+p.getAge()+
				" "+p.getName()+" "+p.getLocation()));
	}
}
