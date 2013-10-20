/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.TomaDeRamos.MB;

import cl.TomaDeRamos.DAO.Autenticacion.UsuarioDAO;
import cl.TomaDeRamos.Entities.Autenticacion.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;

/**
 *
 * @author eduardo
 */
@ManagedBean
@SessionScoped
public class LoginMB {

    private Usuario usuario = new Usuario();
    
    public LoginMB() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void atenticarUsuario() throws NamingException
    {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.autenticarUsuario(usuario);
    }
}
