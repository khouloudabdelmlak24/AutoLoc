package tn.esprit.autoloc.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repositories.EquipementRepository;
import tn.esprit.autoloc.repositories.VehiculeRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class VehiculeServiceImpl implements IVehiculeService {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private EquipementRepository equipementRepository;

    @Override
    public Vehicule ajouter(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule modifier(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void supprimer(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public Vehicule getById(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vehicule> getAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
        if (vehicule == null) {
            throw new RuntimeException("Véhicule introuvable : " + idVehicule);
        }
        Equipement equipement = equipementRepository.findById(idEquipement).orElse(null);
        if (equipement == null) {
            throw new RuntimeException("Équipement introuvable : " + idEquipement);
        }

        if (!vehicule.getEquipements().contains(equipement)) {
            vehicule.getEquipements().add(equipement);      // côté propriétaire (table de jointure)
            equipement.getVehicules().add(vehicule);        // côté inverse
        }

        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
        if (vehicule == null) {
            throw new RuntimeException("Véhicule introuvable : " + idVehicule);
        }
        Equipement equipement = equipementRepository.findById(idEquipement).orElse(null);
        if (equipement == null) {
            throw new RuntimeException("Équipement introuvable : " + idEquipement);
        }

        vehicule.getEquipements().remove(equipement);       // supprime la ligne de la table de jointure
        equipement.getVehicules().remove(vehicule);

        return vehiculeRepository.save(vehicule);
    }

    // Question 1 : démarre 5 s après le lancement, puis toutes les 60 s
    @Scheduled(initialDelay = 5, fixedRate = 60, timeUnit = TimeUnit.SECONDS)
    public void actualiserEtatVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        log.info("Actualisation des véhicules : {} véhicule(s) enregistré(s)", vehicules.size());
        log.info("Date et heure de l'actualisation : {}", LocalDateTime.now().format(FORMAT));
    }

    // Question 3 : tous les lundis à 09h00 (sec min heure jour-du-mois mois jour-de-semaine)
    @Scheduled(cron = "0 0 9 ? * MON")
    public void genererRapportVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        int total = vehicules.size();

        log.info("===== RAPPORT DES VÉHICULES =====");
        log.info("Nombre total de véhicules : {}", total);
        log.info("Rapport généré le : {}", LocalDateTime.now().format(FORMAT));
        log.info("=================================");
    }
}