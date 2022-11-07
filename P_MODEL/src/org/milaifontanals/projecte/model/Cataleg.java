/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.projecte.model;

/**
 *
 * @author jonat
 */
public abstract class Cataleg {
    private long id;
    private String titol;
    private boolean actiu;
    private int estil;
    private char tipus;

    public Cataleg(long id, String titol, boolean actiu, int estil, char tipus) {
        this.id = id;
        this.titol = titol;
        this.actiu = actiu;
        this.estil = estil;
        this.tipus = tipus;
    }

    public Cataleg(long id, String titol) {
        this.id = id;
        this.titol = titol;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public boolean isActiu() {
        return actiu;
    }

    public void setActiu(boolean actiu) {
        this.actiu = actiu;
    }

    public int getEstil() {
        return estil;
    }

    public void setEstil(int estil) {
        this.estil = estil;
    }

    public char getTipus() {
        return tipus;
    }

    public void setTipus(char tipus) {
        this.tipus = tipus;
    }
    
    public String mostraTitol(){
        return titol;
    }

    @Override
    public String toString() {
        return "Cataleg{" + "id=" + id + ", titol=" + titol + ", actiu=" + actiu + ", estil=" + estil + ", tipus=" + tipus + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }
    
    public int getDuracio(){
        int duracio = 0;
        
        return duracio;
    }
}