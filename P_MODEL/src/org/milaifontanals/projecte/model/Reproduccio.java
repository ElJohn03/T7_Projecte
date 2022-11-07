package org.milaifontanals.projecte.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reproduccio{
    private Date timestamp;
    private Client idCli;
    private Cataleg idProd;

    public Reproduccio(Date timestamp, Client idCli, Cataleg idProd) {
        this.timestamp = timestamp;
        this.idCli = idCli;
        this.idProd = idProd;
    }

    public Reproduccio(Date timestamp, Client idCli) {//Proba
        this.timestamp = timestamp;
        this.idCli = idCli;
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

    public Cataleg getIdProd() {
        return idProd;
    }

    public void setIdProd(Cataleg idProd) {
        this.idProd = idProd;
    }

    @Override
    public String toString() {
        return "Reproduccio{" + "timestamp=" + timestamp + ", idCli=" + idCli + ", idProd=" + idProd + '}';
    }
    
    
}