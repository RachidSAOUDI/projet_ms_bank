package ma.usmba.compteservice.repositories;

import ma.usmba.compteservice.entities.TransactionCompte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionCompteRepository extends JpaRepository<TransactionCompte, Long> {
    List<TransactionCompte> findByCompteBancaire_CompteId(String compteId);
}
