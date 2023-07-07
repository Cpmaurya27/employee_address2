package com.example.employeeAddress.repository;

import com.example.employeeAddress.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

}
