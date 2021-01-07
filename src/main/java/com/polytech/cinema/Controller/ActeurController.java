package com.polytech.cinema.Controller;

import com.polytech.cinema.Entity.Acteur;
import com.polytech.cinema.Service.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/acteur")
public class ActeurController {

    private ActeurService as;

    @Autowired
    public ActeurController(ActeurService acteurService) {
        this.as = acteurService;
    }

    @GetMapping("/list")
    public List<Acteur> getActeurs(){
        return as.getActeurs();
    }

    @GetMapping("/{id}")
    public Acteur getActeurById(@PathVariable int id){
        return as.getActeurById(id);
    }

    @PostMapping("/add")
    public Acteur addActeur(@RequestBody Acteur a){
        return as.addActeur(a);
    }

    @DeleteMapping("/{id}")
    public void deleteActeur(@PathVariable int id){
        as.deleteActeur(id);
    }

    @PutMapping("/update")
    public Acteur updateActeur(@RequestBody Acteur a){
        return as.updateActeur(a);
    }
}
