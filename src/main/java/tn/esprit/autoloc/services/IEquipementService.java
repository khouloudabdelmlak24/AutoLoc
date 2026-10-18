package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement ajouter(Equipement equipement);
    Equipement modifier(Equipement equipement);
    void supprimer(Long id);
    Equipement getById(Long id);
    List<Equipement> getAll();
}