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

/**
 *
 * @author Jonathan
 */
public class MilaSpotifyJDBC {
    
    //Creem la Connection
    private Connection con;
    
    //Creem els PreparedStatements
    private PreparedStatement a;
    private PreparedStatement b;
    
    public MilaSpotifyJDBC() throws MilaSpotifyJDBCException {
        this("empresaJDBC.properties");
    }
    
    public MilaSpotifyJDBC(String nomFitxerPropietats) throws MilaSpotifyJDBCException {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(nomFitxerPropietats));
            String[] claus = {"url", "user", "password"};
            String[] valors = new String[3];
            for (int i = 0; i < claus.length; i++) {
                valors[i] = props.getProperty(claus[i]);
                if (valors[i] == null || valors[i].isEmpty()) {
                    throw new MilaSpotifyJDBCException("L'arxiu " + nomFitxerPropietats + " no troba la clau " + claus[i]);
                }
            }
            con = DriverManager.getConnection(valors[0], valors[1], valors[2]);
            con.setAutoCommit(false);
        } catch (IOException ex) {
            throw new MilaSpotifyJDBCException("ERROR AL RECUPERAR L'ARXIU DE CONFIGURACIÓ: " + nomFitxerPropietats + "\n" + ex.getMessage());
        } catch (SQLException ex) {
            throw new MilaSpotifyJDBCException("No es pot establir la connexió.\n" + ex.getMessage());
        }

        String inst = null;
        try {
            inst = "INSERT INTO Producte (prod_num, descripcio) VALUES (?,?)";
            qAddProducte = conn.prepareStatement(inst);
            inst = "UPDATE Producte SET descripcio=? WHERE prod_num=?";
            qUpdProducte = conn.prepareStatement(inst);
            inst = "DELETE FROM PRODUCTE WHERE prod_num IN ?";
            /* Alerta: El paràmetre ha de ser una llista de valors numèrics*/
            qDelListProducte = conn.prepareStatement(inst);
        } catch (SQLException ex) {
            throw new GestorBDEmpresaJdbcException("No es pot crear el PreparedStatement:\n " + inst + "\n" + ex.getMessage());
        }
    }
}
