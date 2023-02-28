package ma.usmba.compteservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import ma.usmba.compteservice.enums.TypeTransaction;

import java.util.Date;

public class TransactionCompte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private double montant;
    private String description;
    @Enumerated(EnumType.STRING)
    private TypeTransaction type;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CompteBancaire compteBancaire;
}
