package tn.esprit.autoloc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.repositories.ContratRepository;
import java.util.List;

@Service
public class ContratServiceImpl implements IContratService {

    @Autowired
    private ContratRepository contratRepository;

    @Override
    public Contrat ajouter(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat modifier(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void supprimer(Long id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat getById(Long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contrat> getAll() {
        return contratRepository.findAll();
    }
}