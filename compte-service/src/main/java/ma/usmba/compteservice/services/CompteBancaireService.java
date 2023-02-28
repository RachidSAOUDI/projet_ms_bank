package ma.usmba.compteservice.services;

import ma.usmba.compteservice.dtos.CompteBancaireDetailsDTO;
import ma.usmba.compteservice.dtos.ComptebancaireDetailsDTO;
import ma.usmba.compteservice.entities.CompteBancaire;
import ma.usmba.compteservice.exceptions.AccountNotFoundException;

import java.util.List;

public interface CompteBancaireService {
    CompteBancaireDetailsDTO getCompteDetails(String compeId) throws AccountNotFoundException;
    List<CompteBancaire> getAllComptes();
}
