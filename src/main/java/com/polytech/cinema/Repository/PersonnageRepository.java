package com.polytech.cinema.Repository;

import com.polytech.cinema.Entity.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnageRepository extends JpaRepository<Personnage, Integer> {

    Personnage getById(int id);
}
