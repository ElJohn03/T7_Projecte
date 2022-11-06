package org.milaifontanals.projecte.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reproduccio{
    private Date timestamp;
    private Client idCli;
    private Producte idProd;

    public Reproduccio(Date timestamp, Client idCli, Producte idProd) {
        this.timestamp = timestamp;
        this.idCli = idCli;
        this.idProd = idProd;
    }

    public String getTimestamp() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        
        String stamp = null;
        
        stamp = dateformat.format(timestamp);
        
        return stamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Client getIdCli() {
        return idCli;
    }

    public void setIdCli(Client idCli) {
        this.idCli = idCli;
    }

    public Producte getIdProd() {
        return idProd;
    }

    public void setIdProd(Producte idProd) {
        this.idProd = idProd;
    }
}