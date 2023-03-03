package com.example.customerservice.mappers;

import com.example.customerservice.dtos.CustomerDTO;
import com.example.customerservice.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    private ModelMapper modelMapper=new ModelMapper();

    public Customer dtoToEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO, Customer.class);
    }

    public CustomerDTO entityToDTO(Customer customer){
        return modelMapper.map(customer, CustomerDTO.class);
    }
}
