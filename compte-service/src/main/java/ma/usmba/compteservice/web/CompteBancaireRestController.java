package ma.usmba.compteservice.web;

import lombok.AllArgsConstructor;
import ma.usmba.compteservice.dtos.CompteBancaireDetailsDTO;
import ma.usmba.compteservice.entities.CompteBancaire;
import ma.usmba.compteservice.exceptions.AccountNotFoundException;
import ma.usmba.compteservice.services.CompteBancaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class CompteBancaireRestController {
    private CompteBancaireService compteBancaireService;
    @GetMapping("/comptes/{id}")
    public ResponseEntity<?> getCompteDetails(@PathVariable(name = "id") String compteId){
        try {
            CompteBancaireDetailsDTO compteDetails=compteBancaireService.getCompteDetails(compteId);
            return ResponseEntity.ok().body(compteDetails);

        } catch (AccountNotFoundException e){
            return ResponseEntity.internalServerError().body(Map.of("errorMessage", e.getMessage()));
        }
    }
    @GetMapping("/comptes")
    public List<CompteBancaire> compteBancaires(){
        return compteBancaireService.getAllComptes();
    }
}
