package com.example.employeeAddress.controller;

import com.example.employeeAddress.models.Employee;
import com.example.employeeAddress.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmpService empService;
    // post new employee in database
    @PostMapping(value = "/employee")
    String addEmployee(@RequestBody Employee employee){
        return empService.addEmployee(employee);
    }

    //Get all employee from database

    @GetMapping(value = "/getAllEmployee")
    public List<Employee> getAllEmployee(){
        return empService.getAllEmployee();
    }

    // Get employee by id
    @GetMapping(value = "/getEmployeeById/{id}")
    ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return empService.getEmployeeById(id);
    }
    //update employee
    @PutMapping(value = "/updateEmployeeById/{id}")
    ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee){
        return empService.updateEmployeeById(id, employee);
    }

    //delete employee
    @DeleteMapping(value = "/deleteEmployeeById/{id}")
    String deleteEmployeeById(@PathVariable Long id){
        return empService.deleteEmployeeById(id);
    }
}
