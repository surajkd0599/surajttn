package com.example.tablesjpa.jpatables.repos;

import com.example.tablesjpa.jpatables.entities.embedded.EmployeeTable;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeTableRepo extends CrudRepository<EmployeeTable,Integer> {
}
