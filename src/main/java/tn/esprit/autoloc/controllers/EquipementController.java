package tn.esprit.autoloc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.services.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
public class EquipementController {

    @Autowired
    private IEquipementService equipementService;

    @PostMapping
    public Equipement ajouter(@RequestBody Equipement equipement) {
        return equipementService.ajouter(equipement);
    }

    @GetMapping
    public List<Equipement> getAll() {
        return equipementService.getAll();
    }

    @GetMapping("/{id}")
    public Equipement getById(@PathVariable Long id) {
        return equipementService.getById(id);
    }

    @PutMapping
    public Equipement modifier(@RequestBody Equipement equipement) {
        return equipementService.modifier(equipement);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        equipementService.supprimer(id);
    }
}