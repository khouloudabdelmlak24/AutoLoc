package tn.esprit.autoloc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Client;
import tn.esprit.autoloc.services.IClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping
    public Client ajouter(@RequestBody Client client) {
        return clientService.ajouter(client);
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id) {
        return clientService.getById(id);
    }

    @PutMapping
    public Client modifier(@RequestBody Client client) {
        return clientService.modifier(client);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        clientService.supprimer(id);
    }
}