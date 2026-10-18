package tn.esprit.autoloc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.repositories.EmployeRepository;
import java.util.List;

@Service
public class EmployeServiceImpl implements IEmployeService {

    @Autowired
    private EmployeRepository employeRepository;

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
}