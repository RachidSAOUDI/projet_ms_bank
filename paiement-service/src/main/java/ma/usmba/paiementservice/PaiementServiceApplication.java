package ma.usmba.paiementservice;

import ma.usmba.paiementservice.config.PaiementConfigParams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(PaiementConfigParams.class)
public class PaiementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaiementServiceApplication.class, args);
    }

}
