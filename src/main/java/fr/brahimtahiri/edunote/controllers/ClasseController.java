package fr.brahimtahiri.edunote.controllers;

import fr.brahimtahiri.edunote.entities.Classe;
import fr.brahimtahiri.edunote.entities.Etudiant;
import fr.brahimtahiri.edunote.services.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/classes")
public class ClasseController {
    @Autowired
    private ClasseService classeService;

    @GetMapping
    public ResponseEntity<List<Classe>> getAll() {
        return new ResponseEntity<>(this.classeService.getClasses(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Classe> getById(@PathVariable int id) {
        return new ResponseEntity<>(this.classeService.getClasseById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Classe> create(@RequestBody Classe classe) {
        return new ResponseEntity<>(this.classeService.createClasse(classe), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Classe> update(@RequestBody Classe classe) {
        return new ResponseEntity<>(this.classeService.updateClasse(classe), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        this.classeService.deleteByClasseId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{id}/etudiants")
    public ResponseEntity<List<Etudiant>> getEtudiantsByClasseId(@PathVariable int id) {
        return new ResponseEntity<>(this.classeService.getClasseById(id).getEtudiants(), HttpStatus.OK);
    }
}
