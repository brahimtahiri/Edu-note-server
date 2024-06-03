package fr.brahimtahiri.edunote.repositories;

import fr.brahimtahiri.edunote.entities.Classe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends CrudRepository<Classe, Integer> {
}
