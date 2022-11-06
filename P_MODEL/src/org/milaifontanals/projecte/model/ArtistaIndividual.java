/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.projecte.model;

import java.util.Date;

public class ArtistaIndividual extends Artista{
    private Date dataNaixement;

    public ArtistaIndividual(Date dataNaixement, long idArt, String nom) {
        super(idArt, nom);
        this.dataNaixement = dataNaixement;
    }

    public Date getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(Date dataNaixement) {
        this.dataNaixement = dataNaixement;
    }
}