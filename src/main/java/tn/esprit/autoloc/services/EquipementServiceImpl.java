package tn.esprit.autoloc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.repositories.EquipementRepository;
import java.util.List;

@Service
public class EquipementServiceImpl implements IEquipementService {

    @Autowired
    private EquipementRepository equipementRepository;

    @Override
    public Equipement ajouter(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement modifier(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public void supprimer(Long id) {
        equipementRepository.deleteById(id);
    }

    @Override
    public Equipement getById(Long id) {
        return equipementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipement> getAll() {
        return equipementRepository.findAll();
    }
}