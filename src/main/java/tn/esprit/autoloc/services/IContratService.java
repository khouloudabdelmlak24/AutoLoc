package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Contrat;

import java.util.List;

public interface IContratService {
    Contrat ajouter(Contrat contrat);
    Contrat modifier(Contrat contrat);
    void supprimer(Long id);
    Contrat getById(Long id);
    List<Contrat> getAll();
}