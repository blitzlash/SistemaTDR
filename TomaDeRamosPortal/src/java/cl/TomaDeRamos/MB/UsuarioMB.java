/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.TomaDeRamos.MB;

import cl.TomaDeRamos.Entities.Autenticacion.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author eduardo
 */
@ManagedBean
@SessionScoped
public class UsuarioMB {

    /**
     * Creates a new instance of UsuarioMB
     */
    
    private Usuario usuario = new Usuario();
    
    public UsuarioMB() {
        
        

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
