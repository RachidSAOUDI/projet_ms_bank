package ma.usmba.compteservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.usmba.compteservice.enums.StatutCompte;
import ma.usmba.compteservice.enums.TypeCompte;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteBancaire {
    @Id
    private String compteId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    private double Solde;
    private String devise;
    @Enumerated(EnumType.STRING)
    private TypeCompte type;
    @Enumerated(EnumType.STRING)
    private StatutCompte statut;
    private Long idClient;
}
