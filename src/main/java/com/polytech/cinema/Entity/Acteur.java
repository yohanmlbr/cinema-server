package com.polytech.cinema.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "acteur", schema = "cinema")
public class Acteur implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "nom", nullable = false, length = 20)
    private String nom;

    @Basic
    @Column(name = "prenom", nullable = false, length = 20)
    private String prenom;

    @Basic
    @Column(name = "date_naissance", nullable = false)
    private Date dateNaissance;

    @Basic
    @Column(name = "date_deces")
    private Date dateDeces;

    @JsonIgnoreProperties("acteur")
    @OneToMany
    @JoinColumn(name = "acteur_id", referencedColumnName = "id", insertable = false, updatable = false)
    public List<Personnage> personnages;
}
