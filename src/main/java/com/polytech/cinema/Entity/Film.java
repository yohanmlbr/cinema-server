package com.polytech.cinema.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "titre", nullable = false, length = 30)
    private String titre;

    @Basic
    @Column(name = "duree", nullable = false)
    private int duree;

    @Basic
    @Column(name = "date_sortie", nullable = false)
    private Date dateSortie;

    @Basic
    @Column(name = "budget", nullable = false)
    private int budget;

    @Basic
    @Column(name = "montant_recette\t", nullable = false)
    private int montantRecette;

    @Basic
    @Column(name = "realisateur_id", nullable = false)
    private int realisateurId;

    @Basic
    @Column(name = "categorie_id", nullable = false)
    private String categorieId;
}
