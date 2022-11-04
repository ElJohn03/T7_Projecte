/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.model;

import java.util.Date;

public class Grup {
    private Date anyCreacio;

    public Grup(Date anyCreacio) {
        this.anyCreacio = anyCreacio;
    }

    public Date getAnyCreacio() {
        return anyCreacio;
    }

    public void setAnyCreacio(Date anyCreacio) {
        this.anyCreacio = anyCreacio;
    }
}