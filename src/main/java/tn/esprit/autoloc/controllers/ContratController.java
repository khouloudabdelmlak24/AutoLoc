package tn.esprit.autoloc.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.services.IContratService;
import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@AllArgsConstructor
@Tag(name="gestion des contrats")
public class ContratController {

    private final  IContratService contratService;

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