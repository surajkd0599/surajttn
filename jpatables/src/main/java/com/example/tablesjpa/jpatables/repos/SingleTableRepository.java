package com.example.tablesjpa.jpatables.repos;

import com.example.tablesjpa.jpatables.entities.singletable.EmployeeSingle;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface SingleTableRepository extends CrudRepository<EmployeeSingle, Integer> {
}
