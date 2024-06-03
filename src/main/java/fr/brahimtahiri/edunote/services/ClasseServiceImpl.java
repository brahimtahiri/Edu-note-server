package fr.brahimtahiri.edunote.services;

import fr.brahimtahiri.edunote.entities.Classe;
import fr.brahimtahiri.edunote.entities.Etudiant;
import fr.brahimtahiri.edunote.exceptions.RessourceNotFoundException;
import fr.brahimtahiri.edunote.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseServiceImpl implements ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private EtudiantService etudiantService;

    @Override
    public List<Classe> getClasses() {
        return (List<Classe>) classeRepository.findAll();
    }

    @Override
    public Classe getClasseById(int id) {
        return this.classeRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("La classe n°" + id + " n'existe pas !"));
    }

    @Override
    public Classe createClasse(Classe classe_to_add) {
        return this.classeRepository.save(classe_to_add);
    }

    @Override
    public Classe updateClasse(Classe classe_to_update) {
        if (classeRepository.existsById(classe_to_update.getId())) {
            return this.classeRepository.save(classe_to_update);
        } else {
            throw new RessourceNotFoundException("La classe n°" + classe_to_update.getId() + " n'existe pas !");
        }
    }

    @Override
    public void deleteByClasseId(int id) {
        if (classeRepository.existsById(id)) {
            Classe classe = this.getClasseById(id);

            for (Etudiant etudiant : classe.getEtudiants()) {
                etudiant.setClasse(null);
                this.etudiantService.updateEtudiant(etudiant);
            }

            this.classeRepository.deleteById(id);
        } else {
            throw new RessourceNotFoundException("La classe n°" + id + " n'existe pas !");
        }
    }
}
