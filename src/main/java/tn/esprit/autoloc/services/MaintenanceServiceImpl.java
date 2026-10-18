package tn.esprit.autoloc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Maintenance;
import tn.esprit.autoloc.repositories.MaintenanceRepository;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements IMaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance ajouter(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance modifier(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void supprimer(Long id) {
        maintenanceRepository.deleteById(id);
    }

    @Override
    public Maintenance getById(Long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Maintenance> getAll() {
        return maintenanceRepository.findAll();
    }
}