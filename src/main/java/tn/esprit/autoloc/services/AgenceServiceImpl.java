package tn.esprit.autoloc.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repositories.AgenceRepository;
import tn.esprit.autoloc.repositories.VehiculeRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AgenceServiceImpl implements IAgenceService {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

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

    // Question 2 : 2 minutes après la FIN de chaque exécution
    @Scheduled(fixedDelay = 2, timeUnit = TimeUnit.MINUTES)
    public void suivreNombreAgences() {
        List<Agence> agences = agenceRepository.findAll();
        log.info("Suivi des agences : {} agence(s) enregistrée(s)", agences.size());
        log.info("Date et heure de la vérification : {}", LocalDateTime.now().format(FORMAT));
    }
}