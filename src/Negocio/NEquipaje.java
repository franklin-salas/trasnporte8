package Negocio;


import Datos.DCliente;
import Datos.DEncomienda;
import Datos.DEquipaje;
import Entidad.Cliente;
import Entidad.Encomienda;
import Entidad.Equipaje;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:22
 */
public class NEquipaje {

    
  
    public static boolean  insertar(Equipaje equipaje){
         if(validacion(equipaje)){
       DEquipaje bol = new DEquipaje();
       if(bol.buscar(equipaje.getCod())== null){
      if( !bol.insertar(equipaje)){
    JOptionPane.showMessageDialog(null, "Error: No se logro Insertar", "Equipaje", JOptionPane.ERROR_MESSAGE);      
          return  false;
      }   }else{
         if(!bol.editar(equipaje)){        
    JOptionPane.showMessageDialog(null, "Error: No se logro Editar", "Equipaje", JOptionPane.ERROR_MESSAGE);      
          return  false;
         }  
           
           
       }} 
         return  true;
    }
       
    public  static Equipaje buscar(int codEq){
         DEquipaje bol = new DEquipaje();
    Equipaje c = bol.buscar(codEq);
    if(c==null){
     JOptionPane.showMessageDialog(null, "Equipaje: No se Encontro", "Equipaje", JOptionPane.INFORMATION_MESSAGE); 
    }
    
     return c;
    
    }
    
    public static int ObetenerCodigoNuevo(){
        DEquipaje bol = new DEquipaje();
     return bol.siguienteCodigo();
    }

public static  List<Equipaje > buscarporNota(int idNota){
    DEquipaje bol = new DEquipaje();
  List<Equipaje> c = bol.buscarPorNota(idNota);
      if(c==null){
     JOptionPane.showMessageDialog(null,  "Equipaje: No se Encontro", "Equipaje", JOptionPane.INFORMATION_MESSAGE); 
    } 
     return c;
   
}
public static List<Equipaje> buscar(){
 
    DEquipaje bol = new DEquipaje();
  return bol.buscar();

}
   
    private static  boolean validacion(Equipaje  equipaje){
      
      boolean estado = true;   
      String mensaje ="";
     
      if (equipaje.getDescripcion().isEmpty()) {
          mensaje="Equipaje : Valor invalido Campo Descripcion (vacia)" ; 
           estado=false;
         }else  if ( equipaje.getDescripcion().length()>30) {
          mensaje="Equipaje : Valor invalido Campo Descriocion (Demaciado largo)" ; 
           estado=false;
         }else if(equipaje.getPrecio()<=0){
           mensaje="Equipaje : Valor invalido Campo Precio" ;
            estado=false;
         }else
         if(equipaje.getCantidad()<=0){
           mensaje="Equipaje : Valor invalido Campo Cantida" ;
            estado=false;
         }
         
     if(!estado){
    JOptionPane.showMessageDialog(null, mensaje, "Equipaje", JOptionPane.ERROR_MESSAGE);
     }
     return estado;
     }  
  
}