/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.projecte.model;

public class Estil{
    private long idEstil;
    private String nom;

    public Estil(long idEstil, String nom) {
        this.idEstil = idEstil;
        this.nom = nom;
    }

    public Estil(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public long getIdEstil() {
        return idEstil;
    }

    public void setIdEstil(long idEstil) {
        this.idEstil = idEstil;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}