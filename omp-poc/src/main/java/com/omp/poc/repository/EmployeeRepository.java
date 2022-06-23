package com.omp.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.omp.poc.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
