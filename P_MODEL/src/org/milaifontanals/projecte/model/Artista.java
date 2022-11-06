package org.milaifontanals.projecte.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Artista{
    private long idArt;
    private String nom;

    public Artista(long idArt, String nom) {
        this.idArt = idArt;
        this.nom = nom;
    }

    public long getIdArt() {
        return idArt;
    }

    public void setIdArt(long idArt) {
        this.idArt = idArt;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public List<Canso> getCansonsInterpretades(){
        
        List<Canso> llista = new ArrayList<Canso>();
        
        return llista;
    }
}