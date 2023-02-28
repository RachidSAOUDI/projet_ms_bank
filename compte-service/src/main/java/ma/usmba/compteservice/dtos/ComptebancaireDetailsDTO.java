package ma.usmba.compteservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.usmba.compteservice.entities.TransactionCompte;
import ma.usmba.compteservice.enums.TypeCompte;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComptebancaireDetailsDTO {
    private String compteId;
    private double solde;
    private TypeCompte typeCompte;
    private Long clientId;
    private String prenomClient;
    private String nomClient;
    private List<TransactionCompte> transactionComptes;
}
