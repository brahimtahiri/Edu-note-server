package fr.brahimtahiri.edunote.services;

import fr.brahimtahiri.edunote.entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getEtudiants();

    Etudiant getEtudiantById(int id);

    Etudiant createEtudiant(Etudiant etudiant);

    Etudiant updateEtudiant(Etudiant etudiant);

    void deleteEtudiantById(int id);

    List<Etudiant> getEtudiantWithoutClasse();
}
