package fr.brahimtahiri.edunote.services;

import fr.brahimtahiri.edunote.entities.Classe;

import java.util.List;

public interface ClasseService {
    List<Classe> getClasses();

    Classe getClasseById(int id);

    Classe createClasse(Classe classe);

    Classe updateClasse(Classe classe);

    void deleteByClasseId(int id);
}
