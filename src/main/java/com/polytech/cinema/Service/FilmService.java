package com.polytech.cinema.Service;

import com.polytech.cinema.Entity.Film;
import com.polytech.cinema.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getFilms(){
        return filmRepository.findAll();
    }
}
