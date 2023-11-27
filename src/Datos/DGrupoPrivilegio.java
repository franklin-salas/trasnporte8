/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

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
public class DGrupoPrivilegio {
    
     ConexionDriverSqlServer dbo;

    public DGrupoPrivilegio() {
         try {
             dbo = new ConexionDriverSqlServer();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(DGrupoPrivilegio.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
     
    public boolean  insertar(List<GrupoPrivilegio> lis){
    boolean b= true;
      
           try {
               dbo.conectar();
             PreparedStatement r = dbo.getConnection().prepareStatement("{call  EliminarGrupPrivilegios(?)}");
           r.setInt(1,lis.get(0).getIdGrupo());   
              
            r.execute();
            r.close();
               
               for (GrupoPrivilegio li : lis) {
             r = dbo.getConnection().prepareStatement("{call insertarGrupoPrivilegio(?,?)}");
           r.setInt(1,li.getIdGrupo());   
            r.setInt(2,li.getIdPrivilegio());    
            r.execute();
            r.close();   
               }
      
           }catch (ClassNotFoundException ex) {
          Logger.getLogger(DGrupoPrivilegio.class.getName()).log(Level.SEVERE, null, ex);
          b=  false;
      } 
           catch (SQLException ex) {
              
                JOptionPane.showMessageDialog(null,"ERROR PA "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
               b= false;
           } finally{  try {
               dbo.desconectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DGrupoPrivilegio.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    if(b)    Bitacora.bitacora("Modifico Grupo Privilegio");    
          
   return b;
    }
    
    public List<GrupoPrivilegio> obtener( String Grupo){
        Nota eq=null;
        List<GrupoPrivilegio> lis =null;
       
           try {
            
                 dbo.conectar();
           
               PreparedStatement r = dbo.getConnection().prepareStatement("{call obtenergrupoPrivilegio(?)}");
               r.setString(1,Grupo);
          
             ResultSet s = r.executeQuery();
             lis = new LinkedList<>();
               while (s.next()) {                   
                 lis.add(new GrupoPrivilegio(s.getInt(1), s.getInt(2)));
               }
      s.close();
     r.close();
      dbo.desconectar();
         
           } catch (ClassNotFoundException ex) {
                 Logger.getLogger(DGrupoPrivilegio.class.getName()).log(Level.SEVERE, null, ex);
                 return  null;
             }
           catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"ERROR PA "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
               return null;
           }
      
         
    
 return lis;
    }
    
     public List<GrupoPrivilegio> obtener( int idGrupo){
        Nota eq=null;
        List<GrupoPrivilegio> lis =null;
       
           try {
            
                 dbo.conectar();
           
               PreparedStatement r = dbo.getConnection().prepareStatement("{call obtenergrupoPrivilegios(?)}");
               r.setInt(1,idGrupo);
          
             ResultSet s = r.executeQuery();
             lis = new LinkedList<>();
               while (s.next()) {                   
                 lis.add(new GrupoPrivilegio(s.getInt(1), s.getInt(2)));
               }
      s.close();
     r.close();
      dbo.desconectar();
         
           } catch (ClassNotFoundException ex) {
                 Logger.getLogger(DGrupoPrivilegio.class.getName()).log(Level.SEVERE, null, ex);
                 return  null;
             }
           catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"ERROR PA "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
               return null;
           }
      
         
    
 return lis;
    }
    
}
