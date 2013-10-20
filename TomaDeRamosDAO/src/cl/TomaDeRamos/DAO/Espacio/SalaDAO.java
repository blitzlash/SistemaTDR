/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.TomaDeRamos.DAO.Espacio;

import cl.TomaDeRamos.Entities.Espacio.Sala;
import cl.TomaDeRamos.Conexion.Conexion;
import cl.TomaDeRamos.Entities.Espacio.TipoSala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo
 */
public class SalaDAO {

    private static PreparedStatement psExisteSala   = null;
    private static PreparedStatement psInsertarSala = null;
    private static PreparedStatement psObtenerSalas = null;
    private static PreparedStatement psModificarSalas   = null;
    private static PreparedStatement psSalaEstaAsignada = null;

    public boolean existeSala(int idSala, String nombreSala)
    {
        Connection conn = new Conexion().getConeccion();
        ResultSet rs = null;
        boolean existeSala = false;
        
        if (psExisteSala == null)
        {
            String query = "select count(*) as salas from Sala where sl_id = ? or sl_nombre = ?";
            try 
            {                
                psExisteSala = conn.prepareStatement(query);

            } catch (SQLException ex) 
            {
                Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.print("Error al preparar la consulta existe Sala");              
            }
        }
        try 
        {
            psExisteSala.setInt(1, idSala);
            psExisteSala.setString(2, nombreSala);
            rs = psExisteSala.executeQuery();            
        } catch (SQLException ex) 
        {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("Error al ejecutar la consulta existe Sala");
        }
        try {
            while(rs.next())
            {
                existeSala = (rs.getInt("salas")>0);                          
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
             System.out.print("Error al obtener registro de la consulta existe Sala");
        }        
        return existeSala;
    }
    
        
        
    public int insertarSala(Sala sala)
    {
        Connection conn = new Conexion().getConeccion();
        int salasInsertadas = 0;
        
        if(psInsertarSala ==null)
        {
            String query = "Insert into Sala (sl_nombre,sl_capacidad,tpsl_id) values(?,?,?)";
            try {
                psInsertarSala = conn.prepareStatement(query);
            } catch (SQLException ex) {
                Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            psInsertarSala.setString(1, sala.getNombre());
            psInsertarSala.setInt(2, sala.getCapacidad());
            psInsertarSala.setInt(3, sala.getTipoSala().getId());
            salasInsertadas = psInsertarSala.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return salasInsertadas;         
    }
         
        
    public int eliminarSala()
    {
         return 0;   
    }
    
    public List<Sala> obtenerSalas()
    {
        List<Sala> salas = new ArrayList<>();
        Connection conn = new Conexion().getConeccion();
        if(psObtenerSalas == null)
        {
            String query = "Select * from V_Sala";
            try {
                psObtenerSalas = conn.prepareStatement(query);
            } catch (SQLException ex) {
                Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            ResultSet rs = psObtenerSalas.executeQuery();
            while(rs.next())
            {
                Sala sala = new Sala();
                TipoSala tipoSala = new TipoSala();
                
                tipoSala.setId(rs.getInt("tpsl_id"));
                tipoSala.setNombre(rs.getString("tpsl_nombre"));
                
                sala.setId(rs.getInt("sl_id"));
                sala.setNombre(rs.getString("sl_nombre"));
                sala.setCapacidad(rs.getInt("sl_capacidad"));
                sala.setTipoSala(tipoSala);
                salas.add(sala);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return salas;
    }
    
    public int modificarSala(Sala sala)
    {
        int salasModificadas = 0;
        Connection conn = new Conexion().getConeccion();
        if(psModificarSalas==null)
        {
            String query = "Update Sala set sl_nombre = ?, sl_capacidad = ?, tpsl_id = ? ";
                   query += "where sl_id = ?";
            try {
                psModificarSalas = conn.prepareStatement(query);
            } catch (SQLException ex) {
                Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            psModificarSalas.setString(1, sala.getNombre());
            psModificarSalas.setInt(2, sala.getCapacidad());
            psModificarSalas.setInt(3, sala.getTipoSala().getId());
            psModificarSalas.setInt(4, sala.getId());
            salasModificadas = psModificarSalas.executeUpdate();
                 
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return salasModificadas;
    }     
    
    public boolean tieneAsignacion(int idSala)
    {
        Connection conn = new Conexion().getConeccion();
        boolean conAsignacion = false;
        
        if(psSalaEstaAsignada==null)
        {
            String query = "Select count(*) as asignaciones from Horario where sl_id = ?";
            try {
                psSalaEstaAsignada = conn.prepareStatement(query);
            } catch (SQLException ex) {
                Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }         
        }
        ResultSet rs = null;
        try {
              psSalaEstaAsignada.setInt(1, idSala);
              rs = psSalaEstaAsignada.executeQuery();
          } catch (SQLException ex) {
              Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
        try {
            while(rs.next())
            {
                conAsignacion = (rs.getInt("asignaciones")>0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conAsignacion;        
    }
            
}
