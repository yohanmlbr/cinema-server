package com.polytech.cinema.Entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne
    @JoinColumn(name="acteur_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Acteur acteur;

    @ManyToOne
    @JoinColumn(name="film_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Film film;
}