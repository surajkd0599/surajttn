package com.example.tablesjpa.jpatables.repos;

import com.example.tablesjpa.jpatables.entities.tableperclass.Employee;
import org.springframework.data.repository.CrudRepository;

public interface TablePerClassRepo  extends CrudRepository<Employee,Integer> {
}
