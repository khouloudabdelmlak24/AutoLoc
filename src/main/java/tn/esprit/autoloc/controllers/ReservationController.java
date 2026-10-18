package tn.esprit.autoloc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Reservation;
import tn.esprit.autoloc.services.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @PostMapping
    public Reservation ajouter(@RequestBody Reservation reservation) {
        return reservationService.ajouter(reservation);
    }

    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Reservation getById(@PathVariable Long id) {
        return reservationService.getById(id);
    }

    @PutMapping
    public Reservation modifier(@RequestBody Reservation reservation) {
        return reservationService.modifier(reservation);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        reservationService.supprimer(id);
    }
}