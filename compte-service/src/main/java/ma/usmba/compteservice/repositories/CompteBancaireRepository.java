package ma.usmba.compteservice.repositories;

import ma.usmba.compteservice.entities.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, String> {
}
