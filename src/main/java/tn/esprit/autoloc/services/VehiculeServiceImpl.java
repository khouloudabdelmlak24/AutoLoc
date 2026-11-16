package tn.esprit.autoloc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repositories.EquipementRepository;
import tn.esprit.autoloc.repositories.VehiculeRepository;

import java.util.List;

@Service
public class VehiculeServiceImpl implements IVehiculeService {

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
}