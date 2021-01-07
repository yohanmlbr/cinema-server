package com.polytech.cinema.Controller;

import com.polytech.cinema.Entity.Realisateur;
import com.polytech.cinema.Service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/realisateur")
public class RealisateurController {

    private RealisateurService rs;

    @Autowired
    public RealisateurController(RealisateurService realisateurService) {
        this.rs = realisateurService;
    }

    @GetMapping("/list")
    public List<Realisateur> getRealisateurs(){
        return rs.getRealisateurs();
    }

    @GetMapping("/{id}")
    public Realisateur getRealisateurById(@PathVariable int id){
        return rs.getRealisateurById(id);
    }

    @PostMapping("/add")
    public Realisateur addRealisateur(@RequestBody Realisateur r){
        return rs.addRealisateur(r);
    }

    @DeleteMapping("/{id}")
    public void deleteRealisateur(@PathVariable int id){
        rs.deleteRealisateur(id);
    }

    @PutMapping("/update")
    public Realisateur updateRealisateur(@RequestBody Realisateur r){
        return rs.updateRealisateur(r);
    }
}
