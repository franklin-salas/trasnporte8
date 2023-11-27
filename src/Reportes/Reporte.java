/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Datos.ConexionDriverSqlServer;
import Presentacion.PanelMenu;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author FRANKLIN SALAS
 */
public class Reporte {

public  static  void Bitacora(){
    try {
        
            ConexionDriverSqlServer conexion;
            
            
            conexion = new ConexionDriverSqlServer();
            String dir="src/Reportes/Bitacora.jasper";
         //    Map parametro = new HashMap();
         //    parametro.put("parameter1", fecha+" 00:00:00");
            conexion.conectar();
            JasperPrint report = JasperFillManager.fillReport( dir, null, conexion.getConnection());
            JasperViewer ventana = new JasperViewer(report, false);
            ventana.setTitle("Bitacora");
            ventana.setVisible(true);
            conexion.desconectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (JRException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }


}
public  static  void Boleto(int cod){
    try {
        
            ConexionDriverSqlServer conexion;
            
            
            conexion = new ConexionDriverSqlServer();
             conexion.conectar();
            String dir="src/Reportes/boleto.jasper";
              Map parametro = new HashMap();
             parametro.put("parameter1", cod);
           
            JasperPrint report = JasperFillManager.fillReport( dir, parametro, conexion.getConnection());
            JasperViewer ventana = new JasperViewer(report, false);
            ventana.setTitle("Boleto");
            ventana.setVisible(true);
            conexion.desconectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (JRException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }


} 
public  static  void Nota(int cod){
    try {
        
            ConexionDriverSqlServer conexion;
            
            
            conexion = new ConexionDriverSqlServer();
             conexion.conectar();
            String dir="src/Reportes/nota2.jasper";
              Map parametro = new HashMap();
             parametro.put("parameter1", cod);
           
            JasperPrint report = JasperFillManager.fillReport( dir, parametro, conexion.getConnection());
            JasperViewer ventana = new JasperViewer(report, false);
            ventana.setTitle("Nota");
            ventana.setVisible(true);
            conexion.desconectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (JRException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }


} 
public  static  void Planilla(int cod){
    try {
        
            ConexionDriverSqlServer conexion;
            
            
            conexion = new ConexionDriverSqlServer();
             conexion.conectar();
            String dir="src/Reportes/Planilla.jasper";
              Map parametro = new HashMap();
             parametro.put("parameter1", cod);
           
            JasperPrint report = JasperFillManager.fillReport( dir, parametro, conexion.getConnection());
            JasperViewer ventana = new JasperViewer(report, false);
            ventana.setTitle("Planilla");
            ventana.setVisible(true);
            conexion.desconectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (JRException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }


} 
public  static  void HojaDeSalida(int cod){
    try {
        
            ConexionDriverSqlServer conexion;
            
            
            conexion = new ConexionDriverSqlServer();
             conexion.conectar();
            String dir="src/Reportes/HojaDeSalida.jasper";
              Map parametro = new HashMap();
             parametro.put("parameter1", cod);
           
            JasperPrint report = JasperFillManager.fillReport( dir, parametro, conexion.getConnection());
            JasperViewer ventana = new JasperViewer(report, false);
            ventana.setTitle("Hoja de Salida");
            ventana.setVisible(true);
            conexion.desconectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (JRException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
} 
public  static  void Guia(int cod){
    try {
        
            ConexionDriverSqlServer conexion;
            
            
            conexion = new ConexionDriverSqlServer();
             conexion.conectar();
            String dir="src/Reportes/Guia.jasper";
              Map parametro = new HashMap();
             parametro.put("parameter1", cod);
           
            JasperPrint report = JasperFillManager.fillReport( dir, parametro, conexion.getConnection());
            JasperViewer ventana = new JasperViewer(report, false);
            ventana.setTitle("Guia");
            ventana.setVisible(true);
            conexion.desconectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (JRException ex) {
            Logger.getLogger(PanelMenu.class.getName()).log(Level.SEVERE, null, ex);
        }


} 
}
