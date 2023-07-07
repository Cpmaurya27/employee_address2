package com.example.employeeAddress.service;

import com.example.employeeAddress.models.Address;
import com.example.employeeAddress.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddressRepository iAddressRepository;
    public String addAddress(Address address){
        iAddressRepository.save(address);
        return "Success!!!!!.....";
    }

    public List<Address> getAllAddress() {
        return (List<Address>) iAddressRepository.findAll();
    }

    public ResponseEntity<Address> getAddressById(Long id) {
        Optional<Address> address = iAddressRepository.findById(id);
        if(address.isPresent()){
            return ResponseEntity.ok(address.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Address> updateAddress(Long id, Address address) {
        Optional<Address> existingAddress = iAddressRepository.findById(id);
        if (existingAddress.isPresent()) {
            address.setId(id);
            Address savedAddress = iAddressRepository.save(address);
            return ResponseEntity.ok(savedAddress);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteAddressById(Long id) {
        Optional<Address> address = iAddressRepository.findById(id);
        if (address.isPresent()) {
            iAddressRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
