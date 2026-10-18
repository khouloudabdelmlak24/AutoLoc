package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Employe;

import java.util.List;

public interface IEmployeService {
    Employe ajouter(Employe employe);
    Employe modifier(Employe employe);
    void supprimer(Long id);
    Employe getById(Long id);
    List<Employe> getAll();
}