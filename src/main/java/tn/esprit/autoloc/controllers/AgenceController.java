package tn.esprit.autoloc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.services.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {

    @Autowired
    private IAgenceService agenceService;

    @PostMapping
    public Agence ajouter(@RequestBody Agence agence) {
        return agenceService.ajouter(agence);
    }

    @GetMapping
    public List<Agence> getAll() {
        return agenceService.getAll();
    }

    @GetMapping("/{id}")
    public Agence getById(@PathVariable Long id) {
        return agenceService.getById(id);
    }

    @PutMapping
    public Agence modifier(@RequestBody Agence agence) {
        return agenceService.modifier(agence);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        agenceService.supprimer(id);
    }
}