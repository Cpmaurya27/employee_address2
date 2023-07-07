package com.example.employeeAddress.repository;

import com.example.employeeAddress.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends CrudRepository<Address, Long> {

}
