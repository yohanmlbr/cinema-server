package com.polytech.cinema.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "personnage", schema = "cinema")
public class Personnage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "nom", nullable = false, length = 30)
    private String nom;

    @Basic
    @Column(name = "acteur_id", nullable = false)
    private int acteurId;

    @Basic
    @Column(name = "film_id", nullable = false)
    private int filmId;

    @JsonIgnoreProperties("personnages")
    @ManyToOne
    @JoinColumn(name="acteur_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Acteur acteur;

    @JsonIgnoreProperties("personnages")
    @ManyToOne
    @JoinColumn(name="film_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Film film;
}