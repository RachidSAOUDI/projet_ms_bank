package ma.usmba.customerservice;

import ma.usmba.customerservice.config.CustomerConfigParams;
import ma.usmba.customerservice.entities.Customer;
import ma.usmba.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            for (int i = 1; i <= 5 ; i++) {
                Customer customer=Customer.builder()
                        .firstName("First Name "+i)
                        .lastName("Last Name "+i)
                        .email("f.l"+i+"@gmail.com")
                        .build();
                customerRepository.save(customer);
            }
        };
    }
}
