package com.polytech.cinema.Service;

import com.polytech.cinema.Entity.Film;
import com.polytech.cinema.Exception.RessourceException;
import com.polytech.cinema.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class FilmService {

    @Autowired
    FilmRepository fr;

    public FilmService(FilmRepository filmRepository) {
        this.fr = filmRepository;
    }

    public List<Film> getFilms(){
        return fr.findAll();
    }

    public Film getFilmById(int id){
        Film f= fr.getById(id);
        if(f==null){
            throw new RessourceException("film","id",id);
        }
        return f;
    }

    public Film addFilm(Film f){
        return fr.save(f);
    }

    public void deleteFilm(int id){
        Film f = getFilmById(id);
        fr.delete(f);
    }

    public Film updateFilm(Film f){
        return fr.save(f);
    }
}
