package com.omp.poc.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;

import com.omp.poc.model.Employee;
import com.omp.poc.service.EmployeeService;


 
@RestController

public class EmployeeController {
	
	@Autowired
    private EmployeeService service;
	
	@GetMapping("/employees")
	
	//@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> list() {
	    return service.findAll();
	}
	
	
	
	@GetMapping("/employees/{id}")
	//@RequestMapping(method = RequestMethod.GET, value = "/employees/{id}", produces = "application/json")
	public ResponseEntity<Employee> get( @PathVariable Integer id) {
	    try {
	        Employee employee = service.get(id);
	        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/employees")
	public void add(@RequestBody Employee employee) {
	    service.save(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Integer id) {
	    try {
	        Employee existEmployee = service.get(id);
	        service.save(employee);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping(path="/employees/{id}")
	public void delete(@PathVariable Integer id) {
	    service.delete(id);
	}

}
