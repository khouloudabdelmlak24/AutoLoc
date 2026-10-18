package tn.esprit.autoloc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.services.IContratService;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {

    @Autowired
    private IContratService contratService;

    @PostMapping
    public Contrat ajouter(@RequestBody Contrat contrat) {
        return contratService.ajouter(contrat);
    }

    @GetMapping
    public List<Contrat> getAll() {
        return contratService.getAll();
    }

    @GetMapping("/{id}")
    public Contrat getById(@PathVariable Long id) {
        return contratService.getById(id);
    }

    @PutMapping
    public Contrat modifier(@RequestBody Contrat contrat) {
        return contratService.modifier(contrat);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        contratService.supprimer(id);
    }
}