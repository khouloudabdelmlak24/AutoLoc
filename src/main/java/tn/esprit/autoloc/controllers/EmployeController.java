package tn.esprit.autoloc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.services.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {

    @Autowired
    private IEmployeService employeService;

    @PostMapping
    public Employe ajouter(@RequestBody Employe employe) {
        return employeService.ajouter(employe);
    }

    @GetMapping
    public List<Employe> getAll() {
        return employeService.getAll();
    }

    @GetMapping("/{id}")
    public Employe getById(@PathVariable Long id) {
        return employeService.getById(id);
    }

    @PutMapping
    public Employe modifier(@RequestBody Employe employe) {
        return employeService.modifier(employe);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        employeService.supprimer(id);
    }
}