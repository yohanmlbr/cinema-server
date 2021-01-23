package com.polytech.cinema.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @JsonIgnoreProperties({"realisateur","realisateurId"})
    @OneToMany
    @JoinColumn(name = "realisateur_id", referencedColumnName = "id", updatable = false, insertable = false)
    public List<Film> films;

}