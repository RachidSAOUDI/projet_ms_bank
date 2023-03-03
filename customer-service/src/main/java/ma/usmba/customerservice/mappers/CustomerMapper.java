package ma.usmba.customerservice.mappers;

import ma.usmba.customerservice.dtos.CustomerDTO;
import ma.usmba.customerservice.entities.Customer;
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
