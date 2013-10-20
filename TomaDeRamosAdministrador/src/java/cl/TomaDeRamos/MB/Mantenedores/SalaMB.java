/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.TomaDeRamos.MB.Mantenedores;

import cl.TomaDeRamos.DAO.Espacio.SalaDAO;
import cl.TomaDeRamos.Entities.Espacio.Sala;
import cl.TomaDeRamos.Entities.Espacio.TipoSala;
import cl.TomaDeRamos.DAO.Espacio.TipoSalaDAO;
import cl.TomaDeRamos.Negocio.Mantenedores.MantenedorSala;
import javax.faces.event.ActionEvent;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author eduardo
 */
@ManagedBean
@RequestScoped
public class SalaMB {

    private Sala sala = new Sala();
    private List<TipoSala> tiposDeSala = null;
    private List<Sala> salas = null;
    private SalaDAO salaDAO = new SalaDAO();
    /**
     * Creates a new instance of SalaMB
     */
    
    public SalaMB()
    {
        TipoSalaDAO tipoSalaDAO = new TipoSalaDAO();
        tiposDeSala = tipoSalaDAO.obtenerTiposDeSala();  
        salas = salaDAO.obtenerSalas();
    }
    
    public void onClickGuardarSala(ActionEvent actionEvent)
    {
        
        MantenedorSala mantenedorSala = new MantenedorSala();
        String mensaje = mantenedorSala.guardarSala(sala); 
        salas = salaDAO.obtenerSalas();
        FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null));
        
    }  
    
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<TipoSala> getTiposDeSala() {
        return tiposDeSala;
    }

    public List<Sala> getSalas() {
        return salas;
    }
}
