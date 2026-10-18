package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement ajouter(Paiement paiement);
    Paiement modifier(Paiement paiement);
    void supprimer(Long id);
    Paiement getById(Long id);
    List<Paiement> getAll();
}