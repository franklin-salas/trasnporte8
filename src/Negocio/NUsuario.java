/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DUsuario;
import javax.swing.JOptionPane;

/**
 *
 * @author FRANKLIN SALAS
 */
public class NUsuario {
    
    
    public static boolean iniciar(String nombre , String clave){
    DUsuario u = new DUsuario(); 
   if(nombre.isEmpty() || clave.isEmpty()){
        JOptionPane.showMessageDialog(null,"Campo Vacio" ,"Usuario",JOptionPane.INFORMATION_MESSAGE);
   }else{
 return u.iniciarSecion(nombre, clave);
   }
    
   
    
 return  false;
    }
    
}
