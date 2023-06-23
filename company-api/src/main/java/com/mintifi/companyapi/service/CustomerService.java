package com.mintifi.companyapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mintifi.companyapi.entity.Customer;
import com.mintifi.companyapi.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public Customer addCustomer(String customerModel) {
        Customer customer;

        try {
            customer = objectMapper.readValue(customerModel, Customer.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Customer save = customerRepository.save(customer);
        return save;
    }

    public List<Customer> getAllCustomer(){
        List<Customer> all = customerRepository.findAll();
        return all;
    }
}