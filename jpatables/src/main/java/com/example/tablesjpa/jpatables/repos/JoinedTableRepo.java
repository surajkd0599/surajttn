package com.example.tablesjpa.jpatables.repos;

import com.example.tablesjpa.jpatables.entities.joinedtable.EmployeeJoined;
import org.springframework.data.repository.CrudRepository;

public interface JoinedTableRepo extends CrudRepository<EmployeeJoined,Integer> {
}
