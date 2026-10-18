package tn.esprit.autoloc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Reservation;
import tn.esprit.autoloc.repositories.ReservationRepository;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation ajouter(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation modifier(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void supprimer(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }
}