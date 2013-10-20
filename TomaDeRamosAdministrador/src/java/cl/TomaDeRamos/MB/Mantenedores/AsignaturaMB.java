/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.TomaDeRamos.MB.Mantenedores;

import cl.TomaDeRamos.Entities.Asignatura;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author fel
 */
@ManagedBean(name="asignaturaMB")
@RequestScoped
public class AsignaturaMB {
    
  private Asignatura asign = new Asignatura();
  private List<Asignatura> asignaturasRequisitos = new ArrayList<Asignatura>();
  
  public AsignaturaMB(){}

    public Asignatura getAsignatura() {
        return asign;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asign = asignatura;
    }
    
    public List<Asignatura> obtenerAsignaturas()
    {
        return new ArrayList<Asignatura>();
    }

    public List<Asignatura> getAsignaturasRequisitos() {
        return asignaturasRequisitos;
    }

    public void setAsignaturasRequisitos(List<Asignatura> asignaturasRequisitos) {
        this.asignaturasRequisitos = asignaturasRequisitos;
    }
  

    
    
}
