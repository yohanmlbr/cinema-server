package com.polytech.cinema.Entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name="realisateur_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Realisateur realisateur;

    @ManyToOne
    @JoinColumn(name="categorie_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Categorie categorie;
}
