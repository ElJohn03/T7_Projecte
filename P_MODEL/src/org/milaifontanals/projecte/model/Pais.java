/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.projecte.model;

/**
 *
 * @author jonat
 */
public class Pais {
    private String isn;
    private String nom;

    public Pais(String isn, String nom) {
        this.isn = isn;
        this.nom = nom;
    }

    public String getIso() {
        return isn;
    }

    public void setIso(String iso) {
        this.isn = iso;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
