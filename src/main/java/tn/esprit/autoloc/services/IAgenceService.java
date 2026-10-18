package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Agence;

import java.util.List;

public interface IAgenceService {
    Agence ajouter(Agence agence);
    Agence modifier(Agence agence);
    void supprimer(Long id);
    Agence getById(Long id);
    List<Agence> getAll();
}