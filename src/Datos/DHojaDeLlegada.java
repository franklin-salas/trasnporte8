/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo
 */
public class DHojaDeLlegada {

	private int id;
	private String hora;
	private String fecha;
        private int codPlanilla;
        
    ConexionDriverSqlServer conectar;
    public DHojaDeLlegada() throws ClassNotFoundException{
            conectar=new ConexionDriverSqlServer();
    }
    
    public String Insertar(int id,String hora,String fecha,int codPlanilla){
       try {
            conectar.conectar();
            Connection conecta=conectar.getConnection();
            CallableStatement proc = conecta.prepareCall(" EXEC AddHojaDeLlegada ?,?,?,?");
            proc.setInt("id", id);
            proc.setString("hora", hora);
            proc.setString("fecha",fecha);
            proc.setInt("codPlanilla",codPlanilla);
            proc.execute();
            conectar.desconectar();
              Bitacora.bitacora("Inserto Hoja de llegada");
            return "HOJA DE LLEGADA REGISTRADA CORRECTAMENTE";
      }catch (Exception  exception) {
        return "DATOS INVALIDOS "+exception.getMessage();        
      }
    }
    
    public String[] ConsultaBuscar(String id){
        String[] v=new String[4];
        try {   
        ResultSet res = conectar.consulta("select * from hojaDeLlegada where id="+id);
        res.next();
        v[0]=String.valueOf( res.getInt("id")); 
        v[1]=res.getString("hora"); 
        v[2]=res.getString("fecha");
        v[3]=String.valueOf( res.getInt("codPlanilla")); 
        res.close();
       Bitacora.bitacora("Busco Hoja de llegada");
        return v;
        }catch (Exception  exception) {
            return null;
        }
    }
    
    // DEVUELVE LA CANTIDAD DE TUPLAS DE LA TABLA
    public int ObtenerCodigoMaximo(){
        String consulta="select max(id) as cantidad from hojaDeLlegada";
        try {   
            int cantidad=conectar.obtenerCodigoX(consulta);
            return cantidad;
        }catch (Exception  exception) {
            //JOptionPane.showMessageDialog(null, "ERROR DEL SISTEMA"+exception.getMessage());
        }
        return -1;
    }
    
    public String Actualizar(String[] datosActualizar){
       try {     
        for (int i = 0; i < datosActualizar.length; i++) {
             conectar.consulta(datosActualizar[i]);
        }
        
          Bitacora.bitacora("Modifico Hoja de llegada");
        return "DATOS ACTUALIZADOS CORRECTAMENTE";
      }catch (Exception  exception) {
           return exception.getMessage();        
      }
    }
    
    public String[] getDatosActualizar(int id,String hora,String fecha,int codPlanilla,int codDestino){
        String v[]=new String[3];
        v[0]="update hojaDeLlegada set hora='"+hora+ "' where id="+id;
        v[1]="update hojaDeLlegada set fecha='"+fecha+ "' where id="+id;
        v[2]="update hojaDeLlegada set codPlanilla="+codPlanilla+" where id="+id;
        return v;
    }
    
    //INSERTA TODOS LOS DATOS DE LA CLASE CLIENTE Y EQUIPJE
    public void setTodo(int id,String hora,String fecha,int codPlanilla)
    {
         this.id=id;
         this.hora=hora;
         this.hora=fecha;
         this.codPlanilla=codPlanilla;
    }

    public String[][] listaDeHojasDeLlegadas(String fecha) {
        try {   
        ResultSet res = conectar.consulta("select * from hojaDeLlegada where fecha='"+fecha+"'");
        int tuplas=conectar.obtenerCodigoX("select count(id) as cantidad from hojaDeLlegada where fecha='"+fecha+"'");
        String[][] v=new String[tuplas][4];
        for (int i = 0; i < tuplas; i++) {
            res.next();
            v[i][0]=String.valueOf( res.getInt("id")); 
            v[i][1]=res.getString("hora"); 
            v[i][2]=res.getString("fecha");
            v[i][3]=String.valueOf( res.getInt("codPlanilla")); 
        }       
        res.close();
        conectar.desconectar();
        return v;
        }catch (Exception  exception) {
            return null;
        }
    }
}
