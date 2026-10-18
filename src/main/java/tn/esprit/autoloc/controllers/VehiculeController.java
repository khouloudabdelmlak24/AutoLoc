package tn.esprit.autoloc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.services.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {

    @Autowired
    private IVehiculeService vehiculeService;

    @PostMapping
    public Vehicule ajouter(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouter(vehicule);
    }

    @GetMapping
    public List<Vehicule> getAll() {
        return vehiculeService.getAll();
    }

    @GetMapping("/{id}")
    public Vehicule getById(@PathVariable Long id) {
        return vehiculeService.getById(id);
    }

    @PutMapping
    public Vehicule modifier(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifier(vehicule);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        vehiculeService.supprimer(id);
    }
}