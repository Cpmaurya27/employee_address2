package com.example.employeeAddress.service;

import com.example.employeeAddress.models.Employee;
import com.example.employeeAddress.repository.IEmployeeRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    public String addEmployee(Employee employee){
        iEmployeeRepository.save(employee);
        return "Success";
    }

    public List<Employee> getAllEmployee() {
        return (List<Employee>) iEmployeeRepository.findAll();
    }

    public ResponseEntity<Employee> getEmployeeById(Long id) {
        Optional<Employee> emp = iEmployeeRepository.findById(id);
        if(emp.isPresent()){
            return ResponseEntity.ok(emp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Employee> updateEmployeeById(Long id, Employee employee) {
        Optional<Employee> existEmp = iEmployeeRepository.findById(id);
        if(existEmp.isPresent()){
            employee.setId(id);
            return ResponseEntity.ok(iEmployeeRepository.save(employee));

        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    public String deleteEmployeeById(Long id) {
        Optional<Employee> employee = iEmployeeRepository.findById(id);
        if(employee.isPresent()){
            iEmployeeRepository.deleteById(id);
            return "Deletion successfully!!!!!.....";
        }
        else{
            return "Employee with id" + id + "is not present in database!";
        }

    }
}
