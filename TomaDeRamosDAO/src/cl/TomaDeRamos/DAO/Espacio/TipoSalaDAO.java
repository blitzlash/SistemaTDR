/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.TomaDeRamos.DAO.Espacio;

import cl.TomaDeRamos.Entities.Espacio.TipoSala;
import cl.TomaDeRamos.Conexion.Conexion;
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
public class TipoSalaDAO {
    
    private static PreparedStatement psObtenerTiposDeSala = null;
    
    public List<TipoSala> obtenerTiposDeSala()
    {
        List<TipoSala> tiposDeSala = new ArrayList<TipoSala>();
        Connection conn = new Conexion().getConeccion();
        if (psObtenerTiposDeSala == null)
        {
            String query = "Select * from Tipo_sala";
            try {
                psObtenerTiposDeSala = conn.prepareStatement(query);
            } catch (SQLException ex) {
                Logger.getLogger(TipoSalaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        try {
            ResultSet rs = psObtenerTiposDeSala.executeQuery();
            while(rs.next())
            {
                TipoSala tipoSala = new TipoSala();
                tipoSala.setId(rs.getInt("tpsl_id"));
                tipoSala.setNombre(rs.getString("tpsl_nombre"));
                tiposDeSala.add(tipoSala);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoSalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return tiposDeSala;   
    }
    
}
