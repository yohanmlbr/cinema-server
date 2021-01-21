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
@Table(name = "categorie", schema = "cinema")
public class Categorie implements Serializable   {

    @Id
    @Column(name = "id", nullable = false, length = 2)
    private String id;

    @Basic
    @Column(name = "libelle", nullable = false, length = 20)
    private String libelle;

    @Basic
    @Column(name = "image", nullable = false, length = 200)
    private String image;

    @JsonIgnoreProperties("categorie")
    @OneToMany
    @JoinColumn(name = "categorie_id", referencedColumnName = "id", insertable = false, updatable = false)
    public List<Film> films;

}