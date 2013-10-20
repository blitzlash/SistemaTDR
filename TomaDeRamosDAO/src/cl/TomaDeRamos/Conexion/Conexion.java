/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.TomaDeRamos.Conexion;

import java.sql.*;

/**
 *
 * @author palto
 */
public class Conexion 
{
    
    private String host = "localhost";
    private String dbName = "db_tomaDeRamos";
    private String dbUser  = "root";
    private String dbPass = "bwwe3kfd";
    private String port = "3306";
    private static Connection conexion = null;
    private Statement st;
    private ResultSet rs = null;
    private String cadenaConexion = "jdbc:mysql://"+host+":"+port+"/"+dbName;
    
    public Conexion()
    {
        try
        {   if(null== conexion)
            {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection(cadenaConexion,dbUser,dbPass);             
            }
        }
        catch(ClassNotFoundException | SQLException ex)
        {         
            System.out.print("error al conectar");
        }
    }
      
    public Connection getConeccion()
    {
        return this.conexion;
    }    
}