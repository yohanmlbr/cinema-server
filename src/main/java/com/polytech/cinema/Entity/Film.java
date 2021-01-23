package com.polytech.cinema.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "film", schema = "cinema")
public class Film implements Serializable{

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
    @Column(name = "montant_recette", nullable = false)
    private int montantRecette;

    @Basic
    @Column(name = "realisateur_id", nullable = false)
    private int realisateurId;

    @Basic
    @Column(name = "categorie_id", nullable = false, length = 2)
    private String categorieId;

    @JsonIgnoreProperties("films")
    @ManyToOne
    @JoinColumn(name="realisateur_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Realisateur realisateur;

    @JsonIgnoreProperties("films")
    @ManyToOne
    @JoinColumn(name="categorie_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Categorie categorie;

    @JsonIgnoreProperties({"film","filmId"})
    @OneToMany
    @JoinColumn(name = "film_id", referencedColumnName = "id", insertable = false, updatable = false)
    public List<Personnage> personnages;
}
