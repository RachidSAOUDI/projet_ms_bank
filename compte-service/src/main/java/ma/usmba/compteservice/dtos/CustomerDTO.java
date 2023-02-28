package ma.usmba.compteservice.dtos;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String prenom;
    private String nom;
    private String email;
}
