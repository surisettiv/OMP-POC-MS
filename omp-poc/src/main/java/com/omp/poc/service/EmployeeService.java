package com.omp.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omp.poc.model.Employee;
import com.omp.poc.repository.EmployeeRepository;

import java.util.List;

/**
 * Created by Varaha.
 */
@Service
@Transactional
public  class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

   
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }
    
   
    public Employee get(Integer employeeId) {
    	// TODO Auto-generated method stub
    	 return employeeRepo.findById(employeeId).get();
    	 //.getById(employeeId);
    }

   
    public void delete(Integer employeeId) {
    	Employee employee = employeeRepo.getById(employeeId);
        employeeRepo.delete(employee);
    	
    }
        
      
    public void save(Employee employee) {
    	employeeRepo.save(employee);
    }



   
     

    /*  @Override
      public List<Employee> findEmployeeByEmployeeNameStartingWith(String name) {
          return employeeRepo..findEmployeeByEmployeeNameStartingWith(name);
      }

      @Override
      public List<Employee> findEmployeeByEmployeeRole(String role) {
          return employeeRepo.findEmployeeByEmployeeRole(role);
      }
  */
  
}
