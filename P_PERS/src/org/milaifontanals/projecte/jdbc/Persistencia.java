package org.milaifontanals.projecte.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.milaifontanals.projecte.model.Client;
import org.milaifontanals.projecte.model.Estil;
import org.milaifontanals.projecte.model.Reproduccio;

/**
 *
 * @author Jonathan
 */
public class Persistencia {
    
    //Creem la Connection
    private Connection con;
    
    public Persistencia() throws PersistenciaException {
        this("empresaJDBC.properties");
    }
    
    public Persistencia(String nomFitxerPropietats) throws PersistenciaException {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(nomFitxerPropietats));
            String[] claus = {"url", "user", "password"};
            String[] valors = new String[3];
            for (int i = 0; i < claus.length; i++) {
                valors[i] = props.getProperty(claus[i]);
                if (valors[i] == null || valors[i].isEmpty()) {
                    throw new PersistenciaException("L'arxiu " + nomFitxerPropietats + " no troba la clau " + claus[i]);
                }
            }
            con = DriverManager.getConnection(valors[0], valors[1], valors[2]);
            con.setAutoCommit(false);
        } catch (IOException ex) {
            throw new PersistenciaException("ERROR AL RECUPERAR L'ARXIU DE CONFIGURACIÓ: " + nomFitxerPropietats + "\n" + ex.getMessage());
        } catch (SQLException ex) {
            throw new PersistenciaException("No es pot establir la connexió.\n" + ex.getMessage());
        }
    }
    
    //Tancar la Connexió
    public void close() throws PersistenciaException{
        if (con != null){
            try{
                con.rollback();
            } catch (SQLException e){
                throw new PersistenciaException("ERROR AL FER ROLLBACK FINAL:" + e.getMessage() + "\n");
            }
            try{
                con.close();
            } catch (SQLException e){
                throw new PersistenciaException("ERROR AL TANCAR CONEXIÓ: " + e.getMessage() + "\n");
            }
        } 
    }
    
    //Retorna els estils
    public List<Estil> getEstils() throws PersistenciaException{
        List <Estil> estils = new ArrayList<Estil>();
        Statement q = null;
        
        try{
            q = con.createStatement();
            ResultSet rs = q.executeQuery("select estil_id, estil_nom from estil");
            while(rs.next()){
                estils.add(new Estil(rs.getInt("estil_id"), rs.getString("estil_nom")));
            }
            rs.close();
        } catch (SQLException e){
            throw new PersistenciaException("NO S'HA POGUT RECUPERAR ELS ESTILS: " + e.getMessage() + "\n");
        }finally{
            if (q != null){
                try{
                    q.close();
                } catch (SQLException e){
                    throw new PersistenciaException ("NO S'HA POGUT TANCAR LA QUERY DE getEstils(): " + e.getMessage() + "\n");
                }
            }
        }
        
        return estils;
    }
    
    //Agafar Clients i omplir Vista
    public List<Client> llistaClients() throws PersistenciaException{
        List<Client> clients = new ArrayList<Client>();
        Statement q = null;
        
        try{
            
           q = con.createStatement();
           ResultSet rs = q.executeQuery("select client_id, client_nom, client_cognoms from client");
           while(rs.next()){
               clients.add(new Client(rs.getLong("client_id"), rs.getString("client_nom"), rs.getString("client_cognoms")));
           }
           rs.close();
        }catch(SQLException e){
            throw new PersistenciaException("NO S'HA POGUT RECUPERAR ELS CLIENTS: " + e.getMessage() + "\n");
        }finally{
            if (q != null){
                try{
                    q.close();
                }catch(SQLException e){
                    throw new PersistenciaException("NO S'HA POGUT TANCAR LA QUERY DE llistaClients(): " + e.getMessage() + "\n");
                }
            }
        }
        
        return clients;
    }
    
    //Agafar el Client demanat
    public Client getClient(String id) throws PersistenciaException{
        Client client = null;
        Statement q = null;
        try{
            q= con.createStatement();
            ResultSet rs = q.executeQuery("select client_id, client_nom, client_cognoms from client where client_nom='"+id+"'");
            while(rs.next()){
                client =(new Client(rs.getLong("client_id"),rs.getString("client_nom"),rs.getString("client_cognoms")));
            }
            rs.close();
        }catch(SQLException ex){
            throw new PersistenciaException("NO S'HA POGUT RECUPERAR ELS CLIENTS: " + ex.getMessage() + "\n");
        }finally {
            if (q != null) {
                try {
                    q.close();
                } catch (SQLException ex) {
                    throw new PersistenciaException("NO S'HA POGUT TANCAR LA QUERY DE getClient(String id): " + ex.getMessage() + "\n");
                }
            }
        }
       
        return client;
    }
    
    //Afegir Reproduccions
    public void afegirReproduccio(Reproduccio r) throws PersistenciaException{
        Statement q = null;
      
        try{
            q= con.createStatement();
            
            ResultSet rs2 = q.executeQuery("insert into REPRODUCCIO (reproduccio_id_client,reproduccio_moment_temporal) values ("+r.getIdCli().getId()+",'"+r.getTimestamp()+"')");
            rs2=q.executeQuery("commit");
            rs2.close();
        }catch(SQLException ex){
            throw new PersistenciaException("NO S'HA POGUT INSERIR UNA NOVA REPRODUCCIO: " + ex.getMessage() + "\n");
        }finally {
            if (q != null) {
                try {
                    q.close();
                } catch (SQLException ex) {
                    throw new PersistenciaException("NO S'HA POGUT TANCAR LA QUERY de afegirReproduccio(Reproduccio r): " + ex.getMessage() + "\n");
                }
            }
        }
    }
    
    //Comprovar Reproduccio
    public  void llistaReproduccio() throws PersistenciaException{
       List<Reproduccio> repro = new ArrayList<Reproduccio>();
       Client entrada = null;
       Statement q = null;
       try{
            q= con.createStatement();
            ResultSet rs = q.executeQuery("select reproduccio_id_client, reproduccio_moment_temporal from REPRODUCCIO");
            while(rs.next()){
                entrada = new Client(rs.getLong("reproduccio_id_client"));
                repro.add(new Reproduccio(rs.getDate("reproduccio_moment_temporal"),entrada));
            }
            rs.close();
        }catch(SQLException ex){
            throw new PersistenciaException("NO S'HA POGUT RECUPERAR LA LLISTA DE REPRODUCCIONS: " + ex.getMessage() + "\n");
        }finally {
            if (q != null) {
                try {
                    q.close();
                } catch (SQLException e) {
                    throw new PersistenciaException("NO S'HA POGUT TANCAR LA QUERY DE llistaReproduccio(): " + e.getMessage() + "\n");
                }
            }
        }
        
        for(int i =0; i<repro.size();i++){
            System.out.println(repro.get(i).getIdCli().getId()+"-------"+repro.get(i).getTimestamp());
        }
    }
    
    //Omple la taula Reproduccio
    public List<Reproduccio> contingutTaula() throws PersistenciaException{
       List<Reproduccio> reproduccions = new ArrayList<Reproduccio>();
       Client entrada = null;
       Statement q = null;
       try{
            q= con.createStatement();
            ResultSet rs = q.executeQuery("select reproduccio_id_client,reproduccio_moment_temporal,client_nom from reproduccio join client on reproduccio_id_client = client.client_id");

            while(rs.next()){
                
                entrada = new Client(rs.getLong("reproduccio_id_client"),rs.getString("client_nom"));
                reproduccions.add(new Reproduccio(rs.getDate("reproduccio_moment_temporal"),entrada));
            }
            rs.close();
        }catch(SQLException ex){
            throw new PersistenciaException("NO S'HA POGUT RECUPERAR LA LLISTA DE REPRODUCCIONS: " + ex.getMessage() + "\n");
        }finally {
            if (q != null) {
                try {
                    q.close();
                } catch (SQLException e) {
                    throw new PersistenciaException("NO S'HA POGUT TANCAR LA QUERY DE contingutTaula(): " + e.getMessage() + "\n");
                }
            }
        }
        
        return reproduccions;
    }
    
    //Elimina la Reproduccio
    public void eliminarReproduccio(Reproduccio r) throws PersistenciaException{
        Statement q = null;
        long id=0;
        try{
            q= con.createStatement();
            ResultSet rs2 = q.executeQuery("select client_id from client where client_nom = '"+r.getIdCli().getNom()+"'");
            while(rs2.next()){
                id = rs2.getLong("cli_id");
            }
            
            rs2=q.executeQuery("delete from reproduccio where reproduccio_id_client = "+id+" and reproduccio_timestamp='"+r.getTimestamp()+"'");
            rs2=q.executeQuery("commit");
            rs2.close();
        }catch(SQLException ex){
            throw new PersistenciaException("NO S'HA POGUT ELIMINAR LA REPRODUCCIO: " + ex.getMessage() + "\n");
        }finally {
            if (q != null) {
                try {
                    q.close();
                } catch (SQLException e) {
                    throw new PersistenciaException("NO S'HA POGUT TANCAR LA QUERY DE eliminarReproduccio(Reproduccio r): " + e.getMessage() + "\n");
                }
            }
        }
    }
    
    //Agafar Reproduccio del filtre
    public List<Reproduccio> getReproduccio(Reproduccio r) throws PersistenciaException{
        List<Reproduccio> reproduccions = new ArrayList<Reproduccio>();
        Client entrada = null;
        Statement q = null;
        try{
            q= con.createStatement();
            ResultSet rs = q.executeQuery("select reproduccio_id_client, reproduccio_moment_temporal, client_nom from reproduccio join client on reproduccio_id_client = client.client_id  and reproduccio_moment_temporal = '"+r.getTimestamp()+"' and client.client_nom = '"+r.getIdCli().getNom()+"'");
            while(rs.next()){
                entrada = new Client(rs.getLong("reproduccio_id_client"),rs.getString("client_nom"));
                reproduccions.add(new Reproduccio(rs.getDate("reproduccio_moment_temporal"),entrada));
            }
            rs.close();
        }catch(SQLException e){
            throw new PersistenciaException("ERROR AL RECUPERAR LLISTA DE CLIENTS: " + e.getMessage() + "\n");
        }finally {
            if (q != null) {
                try {
                    q.close();
                } catch (SQLException ex) {
                    throw new PersistenciaException("NO S'HA POGUT TANCAR LA QUERY DE getReproduccio(Reproduccio r): " + ex.getMessage() + "\n");
                }
            }
        }
       
        return reproduccions;
    }
}