/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.TomaDeRamos.Negocio.Disponibilidad;

import cl.TomaDeRamos.DAO.ActorDAO;
import cl.TomaDeRamos.Entities.Actores.Actor;
import cl.TomaDeRamos.Entities.Disponibilidad.Bloque;
import cl.TomaDeRamos.Entities.Disponibilidad.Dias;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduardo
 */
public class Disponibilisador {
    
    public Disponibilisador()
    {
    }
    
    
    public void insertarDisponibilidad(Actor actor)
    {      
        List<Dias> dias = dias = new ArrayList<>();        
        dias.add(actor.getDisponibilidad().getLunes());
        dias.add(actor.getDisponibilidad().getMartes());
        dias.add(actor.getDisponibilidad().getMiercoles());
        dias.add(actor.getDisponibilidad().getJueves());
        dias.add(actor.getDisponibilidad().getViernes());
        dias.add(actor.getDisponibilidad().getSabado());
        
         ActorDAO actorDAO = new ActorDAO();
        
        for(Dias dia: dias)
        {
            for(Bloque bloque : dia.getBloques())
            {
                if(bloque.isDisponible())
                {
                    actorDAO.insertarDisponibilidad(actor.getRut(), dia.ordinal(), bloque.getHora());
                }
            }
        } 
    }
    

    
}
