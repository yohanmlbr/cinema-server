package com.polytech.cinema.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "realisateur", schema = "cinema")
public class Realisateur implements Serializable {

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
}