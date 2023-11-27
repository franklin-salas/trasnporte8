package Datos;


import java.sql.CallableStatement;
import java.sql.Types;
import Datos.ConexionDriverSqlServer;
import Entidad.Encomienda;
import Entidad.Equipaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:22
 */
public class DEquipaje {

    ConexionDriverSqlServer dbo;
    public DEquipaje() {
        try {
            dbo = new ConexionDriverSqlServer();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DEquipaje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
public boolean insertar(Equipaje equip){
    
    boolean b= true;
      
           try {
        
            dbo.conectar();
       
               PreparedStatement r = dbo.getConnection().prepareStatement("{call InsertarEquipaje(?,?,?,?,?)}");
           r.setInt(1,equip.getCod());
           r.setString(2,equip.getDescripcion());
           r.setFloat(3,equip.getPrecio());
           r.setInt(4,equip.getCantidad());
           r.setInt(5, equip.getIdNota());
             try {
                 ResultSet s = r.executeQuery();
             while (s.next()){             
            JOptionPane.showMessageDialog(null,"Equipaje : "+ s.getString(1), "Mensaje",JOptionPane.INFORMATION_MESSAGE);            
             b=false;
             } 
              s.close();
               } catch (Exception e) {
               }
     
     r.close();
     dbo.desconectar();
         
           }  catch (ClassNotFoundException ex) {
            Logger.getLogger(DEquipaje.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
           catch (SQLException ex) {
    
                JOptionPane.showMessageDialog(null,"ERROR PA "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
               return false;
           }
      if(b)    Bitacora.bitacora("Inserto Equipaje");
           
   return b;
    }

     public boolean editar (Equipaje equip){
        boolean b= true;
       
           try {
            
                dbo.conectar();
           
               PreparedStatement r = dbo.getConnection().prepareStatement("{call ModificarEquipaje(?,?,?,?,?)}");
           r.setInt(1,equip.getCod());
           r.setString(2,equip.getDescripcion());
           r.setFloat(3,equip.getPrecio());
           r.setInt(4,equip.getCantidad());
           r.setInt(5, equip.getIdNota());
           
               try {
                 ResultSet s = r.executeQuery();
             while (s.next()){             
            JOptionPane.showMessageDialog(null,"Equipaje : "+ s.getString(1), "Mensaje",JOptionPane.INFORMATION_MESSAGE);            
             b=false;
             } 
              s.close();
               } catch (Exception e) {
               }
          
     
     r.close();
     dbo.desconectar();
         
           }catch (ClassNotFoundException ex) {
                Logger.getLogger(DEquipaje.class.getName()).log(Level.SEVERE, null, ex);
           return false;
           } 
           catch (SQLException ex) {
              
                JOptionPane.showMessageDialog(null,"ERROR PA "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
               return false;
           }
      
          if(b)    Bitacora.bitacora("Modifico Equipaje"); 
   return b;
    
    }
    
     public Equipaje   buscar (int codEquip){
          Equipaje eq=null;
     
           try {
             
                  dbo.conectar();
             
               PreparedStatement r = dbo.getConnection().prepareStatement("{call BuscarEquipaje(?)}");
           r.setInt(1,codEquip);
          
             ResultSet s = r.executeQuery();
             if (s.next()){             
       eq= new Equipaje(s.getInt(1),s.getString(2), s.getFloat(3), s.getInt(4), s.getInt(5));}
      s.close();
     r.close();
      dbo.desconectar();
         
           } catch (ClassNotFoundException ex) {
                  Logger.getLogger(DEquipaje.class.getName()).log(Level.SEVERE, null, ex);
            return null;   
           } 
           catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"ERROR PA "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
               return null;
           }
        if(eq != null)    Bitacora.bitacora("Busco Equipaje");
          
   return eq;
    }  
     
     public List<Equipaje>  buscar (){

         
   return null;
    }
     
    public List<Equipaje>  buscarPorNota (int idNota){
              
   return null;
    }  
    
    public int siguienteCodigo(){
      
       int cod=-1;
          
        try {
            dbo.conectar();
            CallableStatement proc = dbo.getConnection().prepareCall("{CALL ObtenerSigCodEquipaje(?)}");
       
            proc.registerOutParameter(1, Types.INTEGER);
            proc.execute();
            
            
            cod =   proc.getInt(1);
            
           dbo.desconectar();
        } catch (ClassNotFoundException ex) {
                  Logger.getLogger(DEquipaje.class.getName()).log(Level.SEVERE, null, ex);
                   return -1;
              } 
        catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"ERROR PA -> -1 "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
               return -1;
        }
        return cod;
    }

}