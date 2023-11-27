/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.Grupo;
import Entidad.GrupoPrivilegio;
import Entidad.Nota;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author FRANKLIN SALAS
 */
public class DGrupo {
    
    ConexionDriverSqlServer dbo ;

    public DGrupo() {
        try {
            dbo =new ConexionDriverSqlServer();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Grupo> obtenerGrupos(){
   Nota eq=null;
        List<Grupo> lis =null;
       
           try {
            
                 dbo.conectar();
           
               PreparedStatement r = dbo.getConnection().prepareStatement("{call obtenerGrupo}");
         
             ResultSet s = r.executeQuery();
             lis = new LinkedList<>();
               while (s.next()) {                   
                 lis.add(new Grupo(s.getInt(1), s.getString(2)));
               }
      s.close();
     r.close();
    
         
           } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"ERROR PA "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
              
                lis= null;
           }
      
           
           catch (ClassNotFoundException ex) {
                 Logger.getLogger(DGrupo.class.getName()).log(Level.SEVERE, null, ex);
                 lis=  null;
             }finally{
       try {
           dbo.desconectar();
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(DGrupo.class.getName()).log(Level.SEVERE, null, ex);
       }
           }
          
         
    
 return lis;
    }
    
    
    
    
}
