/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_transporte;


import Datos.DNota;
import java.awt.Event;



/**
 *
 * @author FRANKLIN SALAS
 */
public class Controlador {
    
    public static int ciUsuario =-1;
     public static String cargo ="";
    public static String cargoUsuario=null ;
    public static int codigoUsuario=-1;
    public static int codigoCliente=-1;
    public static int codigoNota=-1;
    public static int codigoPlanilla=-1;
    public static int codigoGuia=-1;
    public static int codigoBoleto=-1;
    public static int idGrupo=-1;
    public static boolean clienteValidato=false;
   
    public static DNota nota ;
 
    
    public static  boolean  esNumero(String n){
    try {
      Integer.parseInt(n);
    } catch (Exception e) {
        return  false;
    }
return true;
}
 public static  boolean  esNumeroFlotante(String n){
    try {
     Float.parseFloat(n);
    } catch (Exception e) {
        return  false;
    }
return true;
}  
    
    
    
}
