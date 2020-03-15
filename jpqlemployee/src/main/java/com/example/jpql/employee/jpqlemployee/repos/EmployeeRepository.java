package com.example.jpql.employee.jpqlemployee.repos;

import com.example.jpql.employee.jpqlemployee.entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    @Query("from Employee")
    List<Employee> findAllEmployee();

    //Q1
    @Query("Select firstName,lastName from Employee where salary >(Select avg(salary) " +
            "from Employee ORDER BY age ASC, salary DESC)")
    List<Object[]> findBySalary();

    //Q2
    /*@Transactional
    @Modifying
    @Query("Update Employee emp set emp.salary=:salary " +
            "where emp.salary < (select avg(salary) from Employee)")
    List<Object[]> updateSalary(@Param("salary") int salary);*/

    @Query("SELECT avg(salary) from Employee")
    int averageSalary();

    @Transactional
    @Modifying
    @Query("UPDATE Employee emp set emp.salary=:sal where emp.salary<:salary1")
    void updateSalary(@Param("salary1") int salary1,@Param("sal") int sal);

    //Q3
    @Query("SELECT min(salary) from Employee")
    int minimumSalary();
    @Transactional
    @Modifying
    @Query("DELETE from Employee emp where emp.salary=:minSalary")
    void deleteEmployee(@Param("minSalary") int minSalary);

    //Q4
    @Query(value = "SELECT empId,empFirstName,empAge from employeeTable where empLastName like '%Singh'",
            nativeQuery = true)
    List<Object[]> employeeSingh();

    //Q5
    @Transactional
    @Modifying
    @Query(value = "DELETE from employeeTable where empAge > 45",nativeQuery = true)
    void deleteEmployeeByGreaterAge();

}
