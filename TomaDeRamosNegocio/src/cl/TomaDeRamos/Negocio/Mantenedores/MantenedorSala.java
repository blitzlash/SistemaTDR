/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.TomaDeRamos.Negocio.Mantenedores;

import cl.TomaDeRamos.Entities.Espacio.Sala;
import cl.TomaDeRamos.Entities.Espacio.TipoSala;
import cl.TomaDeRamos.DAO.Espacio.SalaDAO;
import cl.TomaDeRamos.DAO.Espacio.TipoSalaDAO;
import java.util.List;

/**
 *
 * @author eduardo
 */
public class MantenedorSala {
    
 
    public String guardarSala(Sala sala)
    {
        try
        {
            SalaDAO salaDAO = new SalaDAO();
            boolean existeSala = salaDAO.existeSala(sala.getId(), sala.getNombre());
            if(existeSala){
                boolean tieneAsignacion = salaDAO.tieneAsignacion(sala.getId());
                if(tieneAsignacion)
                {
                    return "La sala "+sala.getNombre()+" posee asignacion y no se puede modificar";
                }else
                {
                    int i = salaDAO.modificarSala(sala);
                    if(i>0)
                        return "Sala "+sala.getNombre()+" actualizada correctamente";
                    else
                        return "No fue posible actualizar la sala "+sala.getNombre()+". Intentelo nuevamente";
                }
                
            }else
            {
                int salaInsertada = salaDAO.insertarSala(sala);
                if(salaInsertada>0)
                {
                    return "Sala "+sala.getNombre()+" insertada correctamente";
                }
                else
                {
                    return "No fue posible insertar la sala "+sala.getNombre()+". Intentelo nuevamente";
                }               
            } 
        } catch(Exception e)
        {
            return "Error al guardar sala. Contactese con el administrador";
        }        
    }
    
    
}
