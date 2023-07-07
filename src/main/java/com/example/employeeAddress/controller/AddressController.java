package com.example.employeeAddress.controller;

import com.example.employeeAddress.models.Address;
import com.example.employeeAddress.service.AddressService;
import com.example.employeeAddress.service.EmpService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    // Add address
    @PostMapping(value = "/address")
    String addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    // get all Address

    @GetMapping(value = "/getAllAddress")
    List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }
    // get Address by id
    @GetMapping(value = "/getAddressById/{id}")
    ResponseEntity<Address> getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }
    // update address
    @PutMapping(value = "/updateAddressById/{id}")
    ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address){
        return addressService.updateAddress(id, address);
    }
    // delete Address by id
    @DeleteMapping(value = "/deleteAddressById/{id}")
    ResponseEntity<Void> deleteAddressById(@PathVariable Long id){
        return addressService.deleteAddressById(id);
    }


}
