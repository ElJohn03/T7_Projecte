/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.projecte.model;

/**
 *
 * @author jonat
 */
public class Album extends Cataleg{
    private int anyCreacio;

    public Album(int anyCreacio, long id, String titol) {
        super(id, titol);
        this.anyCreacio = anyCreacio;
    }

    public int getAnyCreacio() {
        return anyCreacio;
    }

    public void setAnyCreacio(int anyCreacio) {
        this.anyCreacio = anyCreacio;
    }
}