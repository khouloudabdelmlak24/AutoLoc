package tn.esprit.autoloc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Paiement;
import tn.esprit.autoloc.repositories.PaiementRepository;
import java.util.List;

@Service
public class PaiementServiceImpl implements IPaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    @Override
    public Paiement ajouter(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement modifier(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public void supprimer(Long id) {
        paiementRepository.deleteById(id);
    }

    @Override
    public Paiement getById(Long id) {
        return paiementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Paiement> getAll() {
        return paiementRepository.findAll();
    }
}