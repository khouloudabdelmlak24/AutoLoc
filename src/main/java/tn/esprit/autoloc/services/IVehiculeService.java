package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule ajouter(Vehicule vehicule);
    Vehicule modifier(Vehicule vehicule);
    void supprimer(Long id);
    Vehicule getById(Long id);
    List<Vehicule> getAll();

    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);
}