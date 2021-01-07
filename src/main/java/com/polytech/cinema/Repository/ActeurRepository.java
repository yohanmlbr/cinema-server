package com.polytech.cinema.Repository;

import com.polytech.cinema.Entity.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur, Integer> {

    Acteur getById(int id);
}
