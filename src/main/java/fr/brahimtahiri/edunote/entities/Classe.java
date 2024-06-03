package fr.brahimtahiri.edunote.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "classes")
@Getter
@Setter
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String denomination;

    @JsonIgnore
    @OneToMany(mappedBy = "classe")
    private List<Etudiant> etudiants;
}
