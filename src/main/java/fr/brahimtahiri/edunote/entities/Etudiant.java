package fr.brahimtahiri.edunote.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "etudiants")
@Getter
@Setter
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String prenom;

    private String url_photo;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;
}
