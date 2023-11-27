/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import Datos.ConexionDriverSqlServer;
import Entidad.Equipaje;
import Entidad.Nota;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo
 */
public class DNota {
    
  ConexionDriverSqlServer dbo;
  
    public DNota() {
      try {
          dbo = new ConexionDriverSqlServer();
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(DNota.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    
    public boolean insertar(Nota nota){
      boolean b= true;
      
           try {
               dbo.conectar();
           
               PreparedStatement r = dbo.getConnection().prepareStatement("{call InsertarNota(?,?,?,?,?)}");
           r.setInt(1,nota.getId());
           r.setFloat(2,nota.getCosto());
           r.setString(3,nota.getFecha());
           r.setString(4,nota.getHora());
           r.setInt(5, nota.getIdCliente());
         r.execute();
         
          
     
     r.close();
     dbo.desconectar();
         Bitacora.bitacora("Inserto Nota"); 
           }catch (ClassNotFoundException ex) {
          Logger.getLogger(DNota.class.getName()).log(Level.SEVERE, null, ex);
          return  false;
      } 
           catch (SQLException ex) {
              
                JOptionPane.showMessageDialog(null,"ERROR PA "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
               return false;
           }
      
          
   return b;
    }

     public boolean editar (Nota nota){
    boolean b= true;
       
           try {
      
            dbo.conectar();
                   
               PreparedStatement r = dbo.getConnection().prepareStatement("{call ModificarNota(?,?,?)}");
           r.setInt(1,nota.getId());
           r.setFloat(2,nota.getCosto());
       
           r.setInt(3, nota.getIdCliente());
         r.execute();
         
          
     
     r.close();
     dbo.desconectar();
        Bitacora.bitacora("Modifico Nota");  
           }catch (ClassNotFoundException ex) {
            Logger.getLogger(DNota.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
           catch (SQLException ex) {
           
                JOptionPane.showMessageDialog(null,"ERROR PA "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
               return false;
           }
      
          
   return b;
    }
    
     public Nota   buscar (int idNota){
         Nota eq=null;
       
           try {
            
                 dbo.conectar();
           
               PreparedStatement r = dbo.getConnection().prepareStatement("{call BuscarNota(?)}");
           r.setInt(1,idNota);
          
             ResultSet s = r.executeQuery();
             if (s.next()){             
       eq= new Nota(s.getInt(1), s.getFloat(2),s.getDate(3).toString(),s.getTime(4).toString(),s.getInt(5));
             }
      s.close();
     r.close();
      dbo.desconectar();
        Bitacora.bitacora("Busco Nota");
           } catch (ClassNotFoundException ex) {
                 Logger.getLogger(DNota.class.getName()).log(Level.SEVERE, null, ex);
                 return  null;
             }
           catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"ERROR PA "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
               return null;
           }
      
          
   return eq;
    }  
     
     public List<Nota>  buscar (){

         
   return null;
    }
     
    public List<Nota>  buscarPorClienteID(int idCliente){
              
   return null;
    } 
     public List<Nota>  buscarPorClienteCI(int ciCliente){
              
   return null;
    } 
     
    public List<Equipaje>  getEquipajes (int idNota){
       List<Equipaje> lis= new LinkedList<>();
      
           try {
           
               dbo.conectar();
           
               PreparedStatement r = dbo.getConnection().prepareStatement("{call MostrarEquipajes(?)}");
           r.setInt(1,idNota);
          
             ResultSet s = r.executeQuery();
             while (s.next()){             
       lis.add(new Equipaje(s.getInt(1),s.getString(2), s.getFloat(3), s.getInt(4), s.getInt(5)));}
      s.close();
     r.close();
      dbo.desconectar();
         
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(DNota.class.getName()).log(Level.SEVERE, null, ex);
               return  null;
           }
           catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"ERROR PA "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
               return null;
           }
      
         
   return lis;    
        
    }
  
       
     public List<Equipaje>  getEquipajes (String Fecha){
              
   return null;
    }
     
    public int siguienteCodigo(){
      
 int cod=-1;
          
        try {
    
         dbo.conectar();
    
            CallableStatement proc = dbo.getConnection().prepareCall("{CALL  ObtenerSigCodNota(?)}");
       
            proc.registerOutParameter(1, Types.INTEGER);
            proc.execute();
            
            
            cod =   proc.getInt(1);
            
           dbo.desconectar();
        }catch (ClassNotFoundException ex) {
         Logger.getLogger(DNota.class.getName()).log(Level.SEVERE, null, ex);
         return -1;
     } 
        catch (SQLException ex) {
             
            JOptionPane.showMessageDialog(null,"ERROR PA -> -1 "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
               return -1;
        }
        return cod;
               
    }
 
    
}
