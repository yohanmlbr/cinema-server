package com.polytech.cinema.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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
}