package fr.brahimtahiri.edunote.services;

import fr.brahimtahiri.edunote.entities.Etudiant;
import fr.brahimtahiri.edunote.exceptions.RessourceNotFoundException;
import fr.brahimtahiri.edunote.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> getEtudiants() {
        return (List<Etudiant>) this.etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(int id) {
        return this.etudiantRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("L'étudiant n°" + id + " n'existe pas !"));
    }

    @Override
    public Etudiant createEtudiant(Etudiant etudiant_to_add) {
        return this.etudiantRepository.save(etudiant_to_add);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant_to_update) {
        if (etudiantRepository.existsById(etudiant_to_update.getId())) {
            return this.etudiantRepository.save(etudiant_to_update);
        } else {
            throw new RessourceNotFoundException("L'étudiant n°" + etudiant_to_update.getId() + " n'existe pas !");
        }
    }

    @Override
    public void deleteEtudiantById(int id) {
        if (etudiantRepository.existsById(id)) {
            etudiantRepository.deleteById(id);
        } else {
            throw new RessourceNotFoundException("L'étudiant n°" + id + " n'existe pas !");
        }
    }
}
