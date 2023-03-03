package ma.usmba.customerservice.web;

import lombok.AllArgsConstructor;
import ma.usmba.customerservice.dtos.CustomerDTO;
import ma.usmba.customerservice.exceptions.CustomerNotFoundException;
import ma.usmba.customerservice.exceptions.EmailAlreadyExistException;
import ma.usmba.customerservice.exceptions.ErrorMessage;
import ma.usmba.customerservice.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class CustomerRestController {
    private CustomerService customerService;
    @GetMapping("/customers")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.allCustomers();
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id){
        try {
            CustomerDTO customerDTO=customerService.customerById(id);
            return  ResponseEntity.ok().body(customerDTO);
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.internalServerError().body(new ErrorMessage(e.getMessage()));
        }
    }
    @PostMapping("/customers")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO customerDTO){
        try {
            CustomerDTO result=customerService.saveCustomer(customerDTO);
            return ResponseEntity.ok().body(result);
        } catch (EmailAlreadyExistException e) {
            return ResponseEntity.internalServerError().body(new ErrorMessage(e.getMessage()));
        }
    }
    @GetMapping("/customers/search")
    public List<CustomerDTO> searchCustomers(@RequestParam(name = "keyword") String keyword){
        return customerService.searchCustomers("%"+keyword+"%");
    }
}
