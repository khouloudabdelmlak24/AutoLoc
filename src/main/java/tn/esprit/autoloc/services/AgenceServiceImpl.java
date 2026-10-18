package tn.esprit.autoloc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.repositories.AgenceRepository;

import java.util.List;

@Service
public class AgenceServiceImpl implements IAgenceService {

    @Autowired
    private AgenceRepository agenceRepository;

    @Override
    public Agence ajouter(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence modifier(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void supprimer(Long id) {
        agenceRepository.deleteById(id);
    }

    @Override
    public Agence getById(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Agence> getAll() {
        return agenceRepository.findAll();
    }
}