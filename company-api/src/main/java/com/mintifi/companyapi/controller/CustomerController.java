package com.mintifi.companyapi.controller;

import com.mintifi.companyapi.entity.Company;
import com.mintifi.companyapi.entity.Customer;
import com.mintifi.companyapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Customer> createCustomer(@RequestBody String payload){
        Customer customer = customerService.addCustomer(payload);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> allCustomer = customerService.getAllCustomer();
        return ResponseEntity.ok(allCustomer);
    }
}
