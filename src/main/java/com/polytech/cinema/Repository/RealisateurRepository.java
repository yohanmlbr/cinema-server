package com.polytech.cinema.Repository;

import com.polytech.cinema.Entity.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealisateurRepository extends JpaRepository<Realisateur, Integer> {

    Realisateur getById(int id);
}
