package com.polytech.cinema.Repository;

import com.polytech.cinema.Entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, String> {

    Categorie getById(String id);
}
