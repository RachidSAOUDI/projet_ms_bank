package com.example.customerservice.services;

import com.example.customerservice.dtos.CustomerDTO;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.exceptions.CustomerNotFoundException;
import com.example.customerservice.exceptions.EmailAlreadyExistException;
import com.example.customerservice.mappers.CustomerMapper;
import com.example.customerservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) throws EmailAlreadyExistException {
        if (customerRepository.verifyIdEmailExists(customerDTO.getEmail()))
            throw new EmailAlreadyExistException(String.format("Email %s already exists", customerDTO.getEmail()));
        Customer customer=customerMapper.dtoToEntity(customerDTO);
        Customer savedCustomer=customerRepository.save(customer);
        CustomerDTO result=customerMapper.entityToDTO(savedCustomer);
        return result;
    }

    @Override
    public List<CustomerDTO> allCustomers() {
        List<Customer> customerList=customerRepository.findAll();
        List<CustomerDTO> result=customerList.stream().map(customerMapper::entityToDTO).collect(Collectors.toList());

        List<CustomerDTO> customerDTOS=new ArrayList<>();
        // ou bien
/*        for (Customer customer:customerList){
            CustomerDTO customerDTO=customerMapper.entityToDTO(customer);
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;*/

        return result;
    }

    @Override
    public CustomerDTO customerById(Long id) throws CustomerNotFoundException {
        Customer customer=customerRepository.findById(id).orElse(null);
        if (customer==null) throw new CustomerNotFoundException("Customer Not Found "+id);
        CustomerDTO customerDTO=customerMapper.entityToDTO(customer);
        return customerDTO;
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public List<CustomerDTO> searchCustomers(String kw) {
        List<Customer> customers=customerRepository.searchCustomers(kw);
        List<CustomerDTO> customerDTOS=customers.stream().map(customerMapper::entityToDTO).collect(Collectors.toList());
        return customerDTOS;
    }
}
