/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DCliente;
import Datos.DEquipaje;
import Datos.DNota;
import Entidad.Cliente;
import Entidad.Equipaje;
import Entidad.Nota;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FRANKLIN SALAS
 */
public class NNota {
   
  
    public static boolean  insertar(Nota nota){
         if(validacion(nota)){
       DNota bol = new DNota();
       if(bol.buscar(nota.getId())== null){
      if( !bol.insertar(nota)){
    JOptionPane.showMessageDialog(null, "Error: No se logro Insertar", "Nota", JOptionPane.ERROR_MESSAGE);      
       return false;
      }   }else{
         if(!bol.editar(nota)){        
    JOptionPane.showMessageDialog(null, "Error: No se logro Editar", "Nota", JOptionPane.ERROR_MESSAGE);      
         return false;
         }  
           
           
       }} 
         return true;
    }
       
    public  static Nota buscar(int idNota){
     DNota bol = new DNota();
    Nota c = bol.buscar(idNota);
    if(c==null){
     JOptionPane.showMessageDialog(null, "Nota: No se Encontro", "Nota", JOptionPane.INFORMATION_MESSAGE); 
    }
    
     return c;
    
    }
    
    public static int ObetenerCodigoNuevo(){
        DNota bol = new DNota();
     return bol.siguienteCodigo();
    }


public static List<Equipaje> getEquipajes( int idNota ){
    DNota bol = new DNota();
  return bol.getEquipajes(idNota);

}
   
   
    private static  boolean validacion(Nota nota){
      
      boolean estado = true;   
      String mensaje ="";
     
      if (nota.getCosto()<0) {
          mensaje="Nota : Valor invalido Campo Costo " ; 
           estado=false;
         }
          
     if(!estado){
    JOptionPane.showMessageDialog(null, mensaje, "Nota", JOptionPane.ERROR_MESSAGE);
     }
     return estado;
     }
}
