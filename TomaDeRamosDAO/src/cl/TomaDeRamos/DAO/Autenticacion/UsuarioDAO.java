/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.TomaDeRamos.DAO.Autenticacion;

import cl.TomaDeRamos.Entities.Autenticacion.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author eduardo
 */
public class UsuarioDAO {
    
    @Resource(name = "db_tdr")
    private DataSource ds;
          
    public UsuarioDAO() throws NamingException
    {
        Context ctx = new InitialContext();
        ds = (DataSource) ctx.lookup("java:comp/env/db_tdr");
        
    }
    
    
    public boolean autenticarUsuario(Usuario usuaio)
    {
        try{
            Connection conn = ds.getConnection();
            if(conn==null)
            {
                return false;
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }           
        return true;
        
        
    }
    
}
