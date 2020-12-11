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
}
