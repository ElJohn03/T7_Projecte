/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p_model;

/**
 *
 * @author jonat
 */
public class Canso extends Producte{
    private int anyCreacio;
    private long durada;

    public Canso(int anyCreacio, long durada, long id, String titol, boolean actiu) {
        super(id, titol, actiu);
        this.anyCreacio = anyCreacio;
        this.durada = durada;
    }

    public int getAnyCreacio() {
        return anyCreacio;
    }

    public void setAnyCreacio(int anyCreacio) {
        this.anyCreacio = anyCreacio;
    }

    public long getDurada() {
        return durada;
    }

    public void setDurada(long durada) {
        this.durada = durada;
    }
}