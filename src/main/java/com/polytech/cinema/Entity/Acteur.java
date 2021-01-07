package com.polytech.cinema.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    @Column(name = "date_deces", nullable = false)
    private Date dateDeces;
}
