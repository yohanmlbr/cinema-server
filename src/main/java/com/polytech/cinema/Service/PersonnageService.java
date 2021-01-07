package com.polytech.cinema.Service;

import com.polytech.cinema.Entity.Personnage;
import com.polytech.cinema.Exception.RessourceException;
import com.polytech.cinema.Repository.PersonnageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonnageService {

    @Autowired
    PersonnageRepository pr;

    public PersonnageService(PersonnageRepository personnageRepository) {
        this.pr = personnageRepository;
    }

    public List<Personnage> getPersonnages(){
        return pr.findAll();
    }

    public Personnage getPersonnageByIds(int id){
        Personnage p= pr.getById(id);
        if(p==null){
            throw new RessourceException("personnage","id",id);
        }
        return p;
    }

    public Personnage addPersonnage(Personnage p){
        return pr.save(p);
    }

    public void deletePersonnage(int id){
        Personnage p = getPersonnageByIds(id);
        pr.delete(p);
    }

    public Personnage updatePersonnage(Personnage p){
        return pr.save(p);
    }
}
