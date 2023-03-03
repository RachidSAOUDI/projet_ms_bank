package ma.usmba.customerservice.services;

import ma.usmba.customerservice.dtos.CustomerDTO;
import ma.usmba.customerservice.exceptions.CustomerNotFoundException;
import ma.usmba.customerservice.exceptions.EmailAlreadyExistException;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO) throws EmailAlreadyExistException;
    List<CustomerDTO> allCustomers();
    CustomerDTO customerById(Long id) throws CustomerNotFoundException;
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long id);
    List<CustomerDTO> searchCustomers(String kw);
}
