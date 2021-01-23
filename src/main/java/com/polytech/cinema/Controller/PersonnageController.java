package com.polytech.cinema.Controller;

import com.polytech.cinema.Entity.Personnage;
import com.polytech.cinema.Service.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/personnage")
public class PersonnageController {

    private PersonnageService ps;

    @Autowired
    public PersonnageController(PersonnageService personnageService) {
        this.ps = personnageService;
    }

    @GetMapping("/list")
    public List<Personnage> getPersonnages(){
        return ps.getPersonnages();
    }

    @GetMapping("/{id}")
    public Personnage getPersonnageById(@PathVariable int id){
        return ps.getPersonnageByIds(id);
    }

    @PostMapping("/add")
    public Personnage addPersonnage(@RequestBody Personnage f){
        return ps.addPersonnage(f);
    }

    @DeleteMapping("/{id}")
    public void deletePersonnage(@PathVariable int id){
        ps.deletePersonnage(id);
    }

    @PutMapping("/update")
    public Personnage updatePersonnage(@RequestBody Personnage f){
        return ps.updatePersonnage(f);
    }
}
