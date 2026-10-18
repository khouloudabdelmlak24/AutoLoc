package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    Maintenance ajouter(Maintenance maintenance);
    Maintenance modifier(Maintenance maintenance);
    void supprimer(Long id);
    Maintenance getById(Long id);
    List<Maintenance> getAll();
}