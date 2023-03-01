package ma.usmba.compteservice;

import ma.usmba.compteservice.entities.CompteBancaire;
import ma.usmba.compteservice.entities.TransactionCompte;
import ma.usmba.compteservice.enums.StatutCompte;
import ma.usmba.compteservice.enums.TypeCompte;
import ma.usmba.compteservice.enums.TypeTransaction;
import ma.usmba.compteservice.repositories.CompteBancaireRepository;
import ma.usmba.compteservice.repositories.TransactionCompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class CompteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CompteBancaireRepository compteBancaireRepository,
                            TransactionCompteRepository transactionCompteRepository){
        return args -> {
            for (int i = 0; i < 6; i++) {
                CompteBancaire compteBancaire=CompteBancaire.builder()
                        .compteId(UUID.randomUUID().toString())
                        .Solde(1200+Math.random()*8700)
                        .dateCreation(new Date())
                        .statut(StatutCompte.CREATED)
                        .type(Math.random()>0.5? TypeCompte.COMPTE_COURRANT:TypeCompte.COMPTE_EPARGNE)
                        .idClient(1L)
                        .build();
                CompteBancaire savedCompteBancaire=compteBancaireRepository.save(compteBancaire);
                for (int j = 0; j < 10; j++) {
                    TransactionCompte transactionCompte=TransactionCompte.builder()
                            .montant(1000+Math.random()*6000)
                            .description("")
                            .date(new Date())
                            .type(Math.random()>0.5? TypeTransaction.DEBIT:TypeTransaction.CREDIT)
                            .compteBancaire(savedCompteBancaire)
                            .build();
                    transactionCompteRepository.save(transactionCompte);
                }
            }
        };
    }
}
