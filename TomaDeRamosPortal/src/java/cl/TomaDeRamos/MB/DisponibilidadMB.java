/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.TomaDeRamos.MB;

import cl.TomaDeRamos.Entities.Actores.Actor;
import cl.TomaDeRamos.Entities.Actores.Profesor;
import cl.TomaDeRamos.Negocio.Disponibilidad.Disponibilisador;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author eduardo
 */
@ManagedBean
@RequestScoped
public class DisponibilidadMB {


    private Actor profesor;
    
    public DisponibilidadMB() {
        profesor = new Profesor();
    }

    public Actor getProfesor() {
        return profesor;
    }

    public void setProfesor(Actor profesor) {
        this.profesor = profesor;
    }

        
    public void grabarDisponibilidad()
    {
          Disponibilisador disponibilisador = new Disponibilisador();
          profesor.setRut(17);
          disponibilisador.insertarDisponibilidad(profesor);         
    }
    
    
    public List<String> rangosDeBloque()
    {
        return null;
    }


}
