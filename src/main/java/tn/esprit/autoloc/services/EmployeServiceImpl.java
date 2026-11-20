package tn.esprit.autoloc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.repositories.AgenceRepository;
import tn.esprit.autoloc.repositories.EmployeRepository;

import java.util.List;

@Service
public class EmployeServiceImpl implements IEmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private AgenceRepository agenceRepository;

    @Override
    public Employe ajouter(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe modifier(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void supprimer(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe getById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employe> getAll() {
        return employeRepository.findAll();
    }

    @Override
    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = employeRepository.findById(idEmploye).orElse(null);
        if (employe == null) {
            throw new RuntimeException("Employé introuvable : " + idEmploye);
        }
        Agence ancienneAgence = employe.getAgence();
        if (ancienneAgence != null) {
            ancienneAgence.getEmployes().remove(employe);   // côté inverse
        }
        employe.setAgence(null);                            // côté propriétaire (clé étrangère)

        return employeRepository.save(employe);
    }
    @Override
    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = employeRepository.findById(idEmploye).orElse(null);
        if (employe == null) {
            throw new RuntimeException("Employé introuvable : " + idEmploye);
        }
        Agence agence = agenceRepository.findById(idAgence).orElse(null);
        if (agence == null) {
            throw new RuntimeException("Agence introuvable : " + idAgence);
        }

        Agence ancienneAgence = employe.getAgence();
        if (ancienneAgence != null) {
            ancienneAgence.getEmployes().remove(employe);   // on le retire de l'ancienne agence
        }
        employe.setAgence(agence);                          // côté propriétaire
        agence.getEmployes().add(employe);                  // côté inverse
        return employeRepository.save(employe);
    }
}