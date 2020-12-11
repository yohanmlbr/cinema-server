package com.polytech.cinema.Repository;

import com.polytech.cinema.Entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    Film getById(int id);
}
