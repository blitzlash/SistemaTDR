/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.TomaDeRamos.MB.Mantenedores;

import cl.TomaDeRamos.DAO.CarreraDAO;
import cl.TomaDeRamos.Entities.Carrera;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;




/**
 *
 * @author fel
 */
@ManagedBean(name="carreraMB")
@RequestScoped
public class CarreraMB {
    
    private Carrera carrera = new Carrera();
    private List<Carrera> listaCarrera;    

    /**
     * Creates a new instance of CarreraMB
     */
    public CarreraMB() {        
        
        CarreraDAO carreraDao = new CarreraDAO();        
        listaCarrera = carreraDao.obtenerCarreras();
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public List<Carrera> getListaCarrera() {
        
        CarreraDAO carreraDao = new CarreraDAO();
        listaCarrera = carreraDao.obtenerCarreras();
        return listaCarrera;
    }
        
    public void agregarCarrera(ActionEvent ev) {
        
        CarreraDAO carreraDao = new CarreraDAO();
        int x = carreraDao.agregarCarrera(carrera);
        
        if (x>0){
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Carrera agregada.", ""));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se ingresó la carrera.", ""));
        }
        
    }    
    
    public void eliminarCarrera(Carrera c) {
        
        CarreraDAO carreraDao = new CarreraDAO();
        int x = carreraDao.eliminarCarrera(c.getId());
        
        if (x>0) {
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Se eliminó:" + c.getNombre() + ".", ""));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "No se eliminó la carrera.", ""));
        }
    }

  
    
}
