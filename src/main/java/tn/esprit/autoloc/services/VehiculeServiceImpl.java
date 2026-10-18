package tn.esprit.autoloc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
public class VehiculeServiceImpl implements IVehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

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
}