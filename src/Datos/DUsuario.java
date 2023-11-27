/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.Usuario;
import Presentacion.PanelMenu;
import Reportes.Reporte;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto_transporte.Controlador;

/**
 *
 * @author FRANKLIN SALAS
 */
public class DUsuario {
    
    ConexionDriverSqlServer dbo;

    public DUsuario() {
        try {
            this.dbo =  new ConexionDriverSqlServer();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   public boolean iniciarSecion(String nombre ,String clave){
     
   boolean b=false;
      
    
        try {
           
          dbo.conectar();
            CallableStatement proc = dbo.getConnection().prepareCall("{CALL IniciarUsuario(?,?,?)}");
            proc.setString(1,nombre );
            proc.setString(2, clave);
            proc.registerOutParameter(3, Types.VARCHAR);
            proc.execute();
            
               
        String mensaje =   proc.getString(3);
         if(mensaje.equals("Inicio Secion")){
             b=true;
           PreparedStatement r = dbo.getConnection().prepareStatement("{call ObtenerCiCargoUsurio(?,?)}");
           r.setString(1,nombre);
           r.setString(2,clave);
             ResultSet s;
              s = r.executeQuery();
             s.next();
       Controlador.ciUsuario=s.getInt(1);
       Controlador.cargo=  s.getString(2);
       //Controlador.idGrupo=s.getInt(3);
       Controlador.idGrupo =1;
       //Controlador.codigoUsuario=s.getInt(4);
       Controlador.codigoUsuario= 1000;
       Bitacora.bitacora(mensaje);
        s.close();
       proc.close();
      
           }else{
     JOptionPane.showMessageDialog(null,mensaje ,JOptionPane.MESSAGE_PROPERTY,JOptionPane.INFORMATION_MESSAGE);}
     
        } catch (SQLException ex) {
            b=false;
            JOptionPane.showMessageDialog(null,"ERROR PA "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
       } catch (ClassNotFoundException ex) {
           b=false;
            Logger.getLogger(DUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           try {
               dbo.desconectar();
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(DUsuario.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
   
   
return b;
   } 
    
    
}
