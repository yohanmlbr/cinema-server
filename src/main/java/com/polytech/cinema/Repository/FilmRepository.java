package com.polytech.cinema.Repository;

import com.polytech.cinema.Entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    Film getById(int id);
    List<Film> getByRealisateurIdAndCategorieId(int r, String c);
    List<Film> getByRealisateurId(int r);
    List<Film> getByCategorieId(String c);
}
