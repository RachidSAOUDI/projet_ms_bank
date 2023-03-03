package com.example.customerservice.services;

import com.example.customerservice.dtos.CustomerDTO;
import com.example.customerservice.exceptions.CustomerNotFoundException;
import com.example.customerservice.exceptions.EmailAlreadyExistException;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO) throws EmailAlreadyExistException;
    List<CustomerDTO> allCustomers();
    CustomerDTO customerById(Long id) throws CustomerNotFoundException;
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long id);
    List<CustomerDTO> searchCustomers(String kw);
}
