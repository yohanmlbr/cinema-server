package com.polytech.cinema.Service;

import com.polytech.cinema.Entity.Realisateur;
import com.polytech.cinema.Exception.RessourceException;
import com.polytech.cinema.Repository.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RealisateurService {

    @Autowired
    RealisateurRepository rr;

    public RealisateurService(RealisateurRepository realisateurRepository) {
        this.rr = realisateurRepository;
    }

    public List<Realisateur> getRealisateurs(){
        return rr.findAll();
    }

    public Realisateur getRealisateurById(int id){
        Realisateur r= rr.getById(id);
        if(r==null){
            throw new RessourceException("realisateur","id",id);
        }
        return r;
    }

    public Realisateur addRealisateur(Realisateur r){
        return rr.save(r);
    }

    public void deleteRealisateur(int id){
        Realisateur r = getRealisateurById(id);
        rr.delete(r);
    }

    public Realisateur updateRealisateur(Realisateur r){
        return rr.save(r);
    }
}
