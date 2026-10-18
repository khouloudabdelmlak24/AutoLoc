package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Client;

import java.util.List;

public interface IClientService {
    Client ajouter(Client client);
    Client modifier(Client client);
    void supprimer(Long id);
    Client getById(Long id);
    List<Client> getAll();
}