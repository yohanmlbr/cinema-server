package com.polytech.cinema.Controller;

import com.polytech.cinema.Entity.Film;
import com.polytech.cinema.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/film")
public class FilmController {

    private FilmService fs;

    @Autowired
    public FilmController(FilmService filmService) {
        this.fs = filmService;
    }

    @GetMapping("/list")
    public List<Film> getFilms(){
        return fs.getFilms();
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable int id){
        return fs.getFilmById(id);
    }

    @PostMapping("/add")
    public Film addFilm(@RequestBody Film f){
        return fs.addFilm(f);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable int id){
        fs.deleteFilm(id);
    }

    @PutMapping("/update")
    public Film updateFilm(@RequestBody Film f){
        return fs.updateFilm(f);
    }

    @GetMapping("/search")
    public List<Film> getFilmsBySearchOnRealisateurAndOrCategorie(@RequestParam(defaultValue = "0") int realisateur,@RequestParam(defaultValue = "") String categorie){
        return fs.getFilmsBySearchOnRealisateurAndOrCategorie(realisateur,categorie);
    }

}
