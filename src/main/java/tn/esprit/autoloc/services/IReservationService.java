package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation ajouter(Reservation reservation);
    Reservation modifier(Reservation reservation);
    void supprimer(Long id);
    Reservation getById(Long id);
    List<Reservation> getAll();
}