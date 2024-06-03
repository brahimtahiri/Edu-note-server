package fr.brahimtahiri.edunote.controllers;

import fr.brahimtahiri.edunote.entities.Etudiant;
import fr.brahimtahiri.edunote.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/etudiants")
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAll() {
        return new ResponseEntity<>(this.etudiantService.getEtudiants(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Etudiant> getById(@PathVariable int id) {
        return new ResponseEntity<>(this.etudiantService.getEtudiantById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Etudiant> create(@RequestBody Etudiant etudiant) {
        return new ResponseEntity<>(this.etudiantService.createEtudiant(etudiant), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Etudiant> update(@RequestBody Etudiant etudiant) {
        return new ResponseEntity<>(this.etudiantService.updateEtudiant(etudiant), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        this.etudiantService.deleteEtudiantById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
