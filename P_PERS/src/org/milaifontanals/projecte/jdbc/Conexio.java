package org.milaifontanals.projecte.jdbc;

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
public class Conexio {
    
    //Creem la Connection
    private Connection con;
    
    //Creem els PreparedStatements
    private PreparedStatement a;
    private PreparedStatement b;
    
    public Conexio() throws ConexioException {
        this("conexioJDBC.properties");
    }
    
}
