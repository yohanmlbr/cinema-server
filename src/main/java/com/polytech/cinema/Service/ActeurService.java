package com.polytech.cinema.Service;

import com.polytech.cinema.Entity.Acteur;
import com.polytech.cinema.Exception.RessourceException;
import com.polytech.cinema.Repository.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActeurService {

    @Autowired
    ActeurRepository ar;

    public ActeurService(ActeurRepository acteurRepository) {
        this.ar = acteurRepository;
    }

    public List<Acteur> getActeurs(){
        return ar.findAll();
    }

    public Acteur getActeurById(int id){
        Acteur a= ar.getById(id);
        if(a==null){
            throw new RessourceException("acteur","id",id);
        }
        return a;
    }

    public Acteur addActeur(Acteur a){
        return ar.save(a);
    }

    public void deleteActeur(int id){
        Acteur a = getActeurById(id);
        ar.delete(a);
    }

    public Acteur updateActeur(Acteur a){
        return ar.save(a);
    }
}
