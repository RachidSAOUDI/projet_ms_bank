package ma.usmba.compteservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.usmba.compteservice.dtos.CompteBancaireDetailsDTO;
import ma.usmba.compteservice.dtos.CustomerDTO;
import ma.usmba.compteservice.entities.CompteBancaire;
import ma.usmba.compteservice.entities.TransactionCompte;
import ma.usmba.compteservice.exceptions.AccountNotFoundException;
import ma.usmba.compteservice.feigns.CustomerRestClient;
import ma.usmba.compteservice.repositories.CompteBancaireRepository;
import ma.usmba.compteservice.repositories.TransactionCompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CompteBancaireServiceImpl implements CompteBancaireService {
    private CompteBancaireRepository compteBancaireRepository;
    private TransactionCompteRepository transactionCompteRepository;
    private CustomerRestClient customerRestClient;

    @Override
    public CompteBancaireDetailsDTO getCompteDetails(String compeId) throws AccountNotFoundException {
        CompteBancaire compteBancaire=compteBancaireRepository.findById(compeId).orElse(null);
        if (compteBancaire==null) throw new AccountNotFoundException("Accoun t not found");
        List<TransactionCompte> transactionList=transactionCompteRepository.findByCompteBancaire_CompteId(compeId);
        CustomerDTO customer=customerRestClient.findCustomerById(compteBancaire.getIdClient());
        CompteBancaireDetailsDTO compteBancaireDetailsDTO=CompteBancaireDetailsDTO.builder()
                .compteId(compteBancaire.getCompteId())
                .solde(compteBancaire.getSolde())
                .typeCompte(compteBancaire.getType())
                .clientId(compteBancaire.getIdClient())
                .transactionComptes(transactionList)
                .prenomClient(customer.getPrenom())
                .nomClient(customer.getNom())
                .build();
        return compteBancaireDetailsDTO;
    }

    @Override
    public List<CompteBancaire> getAllComptes() {
        return compteBancaireRepository.findAll();
    }
}
