package Datos;

import java.sql.ResultSet;
import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:56:05
 */
public class DRuta {

    private int cod;
    private float costo;    
    private String tiempoDeViaje;
    private int codOrigen;
    private int codDestino;
    
    private ConexionDriverSqlServer conectar;
    
    // CONTRUCTOR QUE INICIALIZA LA CONEXION DE LA BASE DE DATOS
    public DRuta() throws ClassNotFoundException{
        conectar=new ConexionDriverSqlServer();
    }
    
    public String Insertar(int cod,float costo,String tiempoDeViaje,String Origen,String Destino){
      try {
            conectar.conectar();
            Connection conecta=conectar.getConnection();
            CallableStatement proc = conecta.prepareCall(" exec AddRuta ?,?,?,?,? ");
            proc.setInt("cod", cod);
            proc.setFloat("costo", costo);
            proc.setTime("tiempoDeViaje", Time.valueOf(tiempoDeViaje));
            proc.setString("Origen", Origen);
            proc.setString("Destino", Destino);
            proc.execute();
            conectar.desconectar();
           Bitacora.bitacora("Inserto Ruta");
            return "RUTA REGISTRADA CORRECTAMENTE";
        } 
       catch (Exception e) {                  
            return "DATOS INVALIDOS "+e.getMessage();
       }
    }
    
    public String[] ConsultaBuscar(String cod){
        String[] v=new String[5];
        try {   
        ResultSet res = conectar.consulta(
            "select r.cod,r.costo,r.tiempoDeViaje,l.nombre as Origen,lu.nombre as Destino "
            + "from ruta r,lugar l,lugar lu where r.cod="+cod+" and r.codOrigen=l.cod and r.codDestino=lu.cod");
        res.next();
        v[0]=String.valueOf( res.getInt("cod")); 
        v[1]=String.valueOf( res.getFloat("costo")); 
        v[2]=String.valueOf(res.getTime("tiempoDeViaje"));
        v[3]=res.getString("Origen"); 
        v[4]=res.getString("Destino"); 
        res.close();
        conectar.desconectar();
        Bitacora.bitacora("Busco Ruta");
        return v;
        }catch (Exception  exception) {
            return null;
        }        
    }
    
    public String[][] ListaDeRutas(){
        String[][] v;
        try {   
        ResultSet res = conectar.consulta(
              "select r.cod,r.costo,r.tiempoDeViaje,l.nombre as Origen,lu.nombre as Destino "
            + "from ruta r,lugar l,lugar lu where r.codOrigen=l.cod and r.codDestino=lu.cod");
        int tuplas=conectar.obtenerCodigoX("select count(cod) as cantidad from ruta");
        v=new String[tuplas][5];
        for (int i = 0; i < tuplas; i++) {
            res.next();
            v[i][0]=String.valueOf( res.getInt("cod")); 
            v[i][1]=String.valueOf( res.getFloat("costo")); 
            v[i][2]=String.valueOf(res.getTime("tiempoDeViaje"));
            v[i][3]=res.getString("Origen");
            v[i][4]=res.getString("Destino");
        }
        res.close();
        conectar.desconectar();
        return v;
        }catch (Exception  exception) {
            return null;
        }        
    }
    
    // DEVUELVE LA CANTIDAD DE TUPLAS DE LA TABLA
    public int ObtenerCodigoMaximo(){
        String consulta="select max(cod) as cantidad from ruta";
        try {   
            int cantidad=conectar.obtenerCodigoX(consulta);
            return cantidad;
        }catch (Exception  exception) {
        //    JOptionPane.showMessageDialog(null, "ERROR DEL SISTEMA"+exception.getMessage());
        }
        return -1;
    }    

    public String Actualizar(int cod,float costo,String tiempoDeViaje,String Origen,String Destino){
      try {
            conectar.conectar();
            Connection conecta=conectar.getConnection();
            CallableStatement proc = conecta.prepareCall(" exec updateRuta ?,?,?,?,? ");
            proc.setInt("cod", cod);
            proc.setFloat("costo", costo);
            proc.setTime("tiempoDeViaje", Time.valueOf(tiempoDeViaje));
            proc.setString("Origen", Origen);
            proc.setString("Destino", Destino);
            proc.execute();
            conectar.desconectar();
          Bitacora.bitacora("Modifico Ruta");
            return "RUTA ACTUALIZADA CORRECTAMENTE";
        } 
       catch (Exception e) {                  
            return "DATOS INVALIDOS "+e.getMessage();
       }
    }    
        
    //INSERTA TODOS LOS DATOS DE LA CLASE CLIENTE Y EQUIPJE
    public void setTodo(int cod,float costo,String tiempoDeViaje,int codOrigen,int codDestino)
    {
         this.cod=cod;
         this.costo=costo;
         this.tiempoDeViaje=tiempoDeViaje;
         this.codOrigen=codOrigen;
         this.codDestino=codDestino;
    }
   
}