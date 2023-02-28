package ma.usmba.compteservice.feigns;

import ma.usmba.compteservice.dtos.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    CustomerDTO findCustomerById(@PathVariable Long id);
}
