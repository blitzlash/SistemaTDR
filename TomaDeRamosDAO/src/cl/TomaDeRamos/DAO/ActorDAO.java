/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.TomaDeRamos.DAO;

import cl.TomaDeRamos.Conexion.*;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;


/**
 *
 * @author eduardo
 */
public class ActorDAO { 
    
    
    private static PreparedStatement psInsertarDisponibilidad = null;
    
    public ActorDAO(){}
   
   
    public int insertarDisponibilidad(int rut, int dia, int bloque)
    {
        Connection conn = new Conexion().getConeccion();
        int filas = 0;
        try
        {                 
            if(null==psInsertarDisponibilidad)
            {
                String query = "insert into Disponibilidad_profesor (disp_dia, disp_bloque, pro_rut) values(?,?,?)";
                psInsertarDisponibilidad =  (PreparedStatement) conn.prepareStatement(query);
            }
            psInsertarDisponibilidad.setInt(1, dia);
            psInsertarDisponibilidad.setInt(2, bloque);
            psInsertarDisponibilidad.setInt(3, rut);
            filas = psInsertarDisponibilidad.executeUpdate();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }        
        return filas;       
    }
    
}
