/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_transporte.Controlador;

/**
 *
 * @author FRANKLIN SALAS
 */
public class Bitacora {
   
    
      public static void  bitacora(String Descripcion ){
    
            try {

                Date dateHoy =new Date();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-hh HH:mm:ss ");
                
                ConexionDriverSqlServer conectar;
                
                
                conectar=new ConexionDriverSqlServer();
                
               
                    conectar.insertar("insert into bitacora values("+Controlador.ciUsuario+""
                            + ",'"+Controlador.cargo+"','"+formato.format(dateHoy)+"','"+Descripcion + "');");
              
                conectar.desconectar();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Bitacora.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
}
