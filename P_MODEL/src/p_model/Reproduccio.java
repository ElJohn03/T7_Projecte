/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p_model;

import java.util.Date;

public class Reproduccio extends Producte{
    private Date timestamp;

    public Reproduccio(Date timestamp, long id, String titol, boolean actiu) {
        super(id, titol, actiu);
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}