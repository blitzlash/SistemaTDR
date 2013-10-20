/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.TomaDeRamos.DAO;



import cl.TomaDeRamos.Conexion.Conexion;
import cl.TomaDeRamos.Entities.Carrera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fel
 */

public class CarreraDAO { 
    
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    /**
     * Creates a new instance of CarreraDAO
     */
    public CarreraDAO() {
        
              
    }
    
    public List<Carrera> obtenerCarreras() {
        
        List<Carrera> lista = new ArrayList();
        
        try{           
            
            Connection conn = new Conexion().getConeccion();
            pstm = conn.prepareStatement("SELECT * FROM carrera");
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next())
            {
                Carrera car = new Carrera();
                car.setId(rs.getInt(1));
                car.setNombre(rs.getString(2));
                car.setSemestres(rs.getInt(3));
                                
                System.out.println(car.getNombre());
                lista.add(car);
            }        
        }
        catch (Exception ex)
        {
            System.out.println("Error producido en método obtener carreras.");
        }               
        return lista;
    }
    
    
    public int agregarCarrera(Carrera c) {
        
        int x = 0;
        try
        {
            String consulta = "INSERT INTO carrera VALUES(?,?,?)";
            Connection conn = new Conexion().getConeccion();
            pstm = conn.prepareStatement(consulta);
            pstm.setInt(1, c.getId());
            pstm.setString(2, c.getNombre());
            pstm.setInt(3, c.getSemestres());
            
            x = pstm.executeUpdate();
        }
        catch (Exception ex)
        {
            System.out.println("Error en el método agregarCarrera");
        }
        return x;
    }
    
    
    public int eliminarCarrera(int id) {
        
        int x = 0;
        try
        {
            String consulta = "DELETE FROM carrera WHERE crr_id = ?";
            Connection conn = new Conexion().getConeccion();
            pstm = conn.prepareStatement(consulta);
            pstm.setInt(1, id);
            
            x = pstm.executeUpdate();                    
        }
        catch (Exception ex)
        {
            System.out.println("Error en el método eliminarCarrera");
        }
        return x;
    }    
    
    
}
