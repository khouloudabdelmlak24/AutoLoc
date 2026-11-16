package tn.esprit.autoloc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repositories.AgenceRepository;
import tn.esprit.autoloc.repositories.VehiculeRepository;

import java.util.List;

@Service
public class AgenceServiceImpl implements IAgenceService {

    @Autowired
    private AgenceRepository agenceRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

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

    @Override
    @Transactional
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        // 1) on enregistre d'abord l'agence pour obtenir son id
        Agence agenceSauvegardee = agenceRepository.save(agence);

        // 2) on enregistre chaque véhicule en l'affectant à l'agence
        for (Vehicule vehicule : agence.getVehicules()) {
            vehicule.setAgence(agenceSauvegardee);
            vehiculeRepository.save(vehicule);
        }

        return agenceSauvegardee;
    }
}