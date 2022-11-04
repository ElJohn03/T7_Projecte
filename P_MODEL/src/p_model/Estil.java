/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p_model;

public class Estil extends Producte{
    private long idEstil;
    private String nom;

    public Estil(long idEstil, String nom, long id, String titol, boolean actiu) {
        super(id, titol, actiu);
        this.idEstil = idEstil;
        this.nom = nom;
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