package com.polytech.cinema.Service;

import com.polytech.cinema.Entity.Categorie;
import com.polytech.cinema.Exception.RessourceException;
import com.polytech.cinema.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategorieService {

    @Autowired
    CategorieRepository cr;

    public CategorieService(CategorieRepository categorieRepository) {
        this.cr = categorieRepository;
    }

    public List<Categorie> getCategories(){
        return cr.findAll();
    }

    public Categorie getCategorieById(String id){
        Categorie c= cr.getById(id);
        if(c==null){
            throw new RessourceException("categorie","id",id);
        }
        return c;
    }

    public Categorie addCategorie(Categorie c){
        return cr.save(c);
    }

    public void deleteCategorie(String id){
        Categorie c = getCategorieById(id);
        cr.delete(c);
    }

    public Categorie updateCategorie(Categorie c){
        return cr.save(c);
    }
}
