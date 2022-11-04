/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p_model;

/**
 *
 * @author jonat
 */
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
}