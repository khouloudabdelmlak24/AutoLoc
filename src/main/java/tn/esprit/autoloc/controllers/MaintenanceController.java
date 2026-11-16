package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Maintenance;
import tn.esprit.autoloc.services.IMaintenanceService;
import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@AllArgsConstructor
public class MaintenanceController {

    private  final IMaintenanceService maintenanceService;

    @PostMapping
    public Maintenance ajouter(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouter(maintenance);
    }

    @GetMapping
    public List<Maintenance> getAll() {
        return maintenanceService.getAll();
    }

    @GetMapping("/{id}")
    public Maintenance getById(@PathVariable Long id) {
        return maintenanceService.getById(id);
    }

    @PutMapping
    public Maintenance modifier(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifier(maintenance);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        maintenanceService.supprimer(id);
    }
}