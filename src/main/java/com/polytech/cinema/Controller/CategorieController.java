package com.polytech.cinema.Controller;

import com.polytech.cinema.Entity.Categorie;
import com.polytech.cinema.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categorie")
public class CategorieController {

    private CategorieService cs;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.cs = categorieService;
    }

    @GetMapping("/list")
    public List<Categorie> getCategories(){
        return cs.getCategories();
    }

    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable String id){
        return cs.getCategorieById(id);
    }

    @PostMapping("/add")
    public Categorie addCategorie(@RequestBody Categorie c){
        return cs.addCategorie(c);
    }

    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable String id){
        cs.deleteCategorie(id);
    }

    @PutMapping("/update")
    public Categorie updateCategorie(@RequestBody Categorie c){
        return cs.updateCategorie(c);
    }
}
