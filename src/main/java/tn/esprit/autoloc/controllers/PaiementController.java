package tn.esprit.autoloc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Paiement;
import tn.esprit.autoloc.services.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private IPaiementService paiementService;

    @PostMapping
    public Paiement ajouter(@RequestBody Paiement paiement) {
        return paiementService.ajouter(paiement);
    }

    @GetMapping
    public List<Paiement> getAll() {
        return paiementService.getAll();
    }

    @GetMapping("/{id}")
    public Paiement getById(@PathVariable Long id) {
        return paiementService.getById(id);
    }

    @PutMapping
    public Paiement modifier(@RequestBody Paiement paiement) {
        return paiementService.modifier(paiement);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        paiementService.supprimer(id);
    }
}