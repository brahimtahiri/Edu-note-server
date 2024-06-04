package fr.brahimtahiri.edunote.repositories;

import fr.brahimtahiri.edunote.entities.Etudiant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {
    Iterable<Etudiant> findByClasseIsNull();
}
