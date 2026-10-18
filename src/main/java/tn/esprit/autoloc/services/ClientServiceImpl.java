package tn.esprit.autoloc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Client;
import tn.esprit.autoloc.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client ajouter(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client modifier(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void supprimer(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}