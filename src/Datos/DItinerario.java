package Datos;

import java.sql.ResultSet;
import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:25
 */
public class DItinerario {

    private int nro;
    private String fecha;
    private String hora;
    private int codRuta;
    
    private ConexionDriverSqlServer conectar;
    
    // CONTRUCTOR QUE INICIALIZA LA CONEXION DE LA BASE DE DATOS
    public DItinerario() throws ClassNotFoundException{
        conectar=new ConexionDriverSqlServer();
    }
    
   public String Insertar(int nro,String fecha,String hora,String origen,String destino)
   {
        try {
            conectar.conectar();
            Connection conecta=conectar.getConnection();
            CallableStatement proc = conecta.prepareCall(" exec AddItinerario ?,?,?,?,? ");
            proc.setInt("nro",nro);
            proc.setString("hora",hora);
            proc.setString("fecha",fecha);
            proc.setString("origen",origen);
            proc.setString("destino",destino);
            proc.execute();
            conectar.desconectar();
           Bitacora.bitacora("Inserto Itinerario");
            return "ITINERARIO REGISTRADO CORRECTAMENTE";
        }catch (Exception e) {
           return "DATOS INVALIDOS "+e.getMessage(); 
        }
       
   }    
    // busca el itinerario por su nro 
    public String[] consultasBuscar(String nro){
        try {   
        ResultSet res = conectar.consulta(
           "select nro,hora,fecha,l.nombre as Origen,lu.nombre as Destino"
         + " from itinerario i, ruta r, lugar l, lugar lu "
         + "where nro="+nro+" and r.cod=i.codRuta and r.codOrigen=l.cod and r.codDestino=lu.cod");
        String[] v=new String[5];
        res.next();
        v[0]=String.valueOf( res.getInt("nro"));
        v[1]=res.getString("hora");
        v[2]=res.getString("fecha");
        v[3]=String.valueOf(res.getString("Origen"));
        v[4]=String.valueOf(res.getString("Destino"));
        res.close();
        conectar.desconectar();
    Bitacora.bitacora("Busco ITinerario");
        return v;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null, "DATOS INVALIDOS "+exception.getMessage());
            return null;
        }        
    }
    
    public String[][] ListaDeItinerarios(){
        try {   
        ResultSet res = conectar.consulta(
           "select nro,hora,fecha,l.nombre as Origen,lu.nombre as Destino "
         + "from itinerario i, ruta r, lugar l, lugar lu " +
           "where r.cod=i.codRuta and r.codOrigen=l.cod and r.codDestino=lu.cod");
        int tuplas = conectar.obtenerCodigoX("select count(nro) as cantidad from itinerario");
        String[][] v=new String[tuplas][5];
        for (int i = 0; i < tuplas; i++) {
            res.next();
            v[i][0]=String.valueOf( res.getInt("nro"));
            v[i][1]=res.getString("hora");
            v[i][2]=res.getString("fecha");
            v[i][3]=res.getString("Origen");
            v[i][4]=res.getString("Destino");
        }
        res.close();
        conectar.desconectar();
        return v;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CAPA DE DATOS "+exception.getMessage());
        }
        return null;
    }
    
    public int ObtenerCodigoMaximo(){
        String consulta="select max(nro) as cantidad from itinerario";
        try {   
            int cantidad=conectar.obtenerCodigoX(consulta);
            return cantidad;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null,"ERROR DEL SISTEMA"+ exception.getMessage());
        }
        return -1;
    }
    
    public String Actualizar(int nro,String fecha,String hora,String origen,String destino){
       try {
            conectar.conectar();
            Connection conecta=conectar.getConnection();
            CallableStatement proc = conecta.prepareCall(" exec updateItinerario ?,?,?,?,? ");
            proc.setInt("nro",nro);
            proc.setString("hora",hora);
            proc.setString("fecha",fecha);
            proc.setString("origen",origen);
            proc.setString("destino",destino);
            proc.execute();
            conectar.desconectar();
               Bitacora.bitacora("Modifico Itinerario");
            return "DATOS ACTUALIZADOS CORRECTAMENTE";
      }catch (Exception  exception) {
           //JOptionPane.showMessageDialog(null, "DATOS INVALIDOS "+exception.getMessage());
           return exception.getMessage();
      } 
    }
    
    //INSERTA TODOS LOS DATOS DE LA CLASE ITINERARIO
    public void setTodo(int nro,String fecha,String hora,int codRuta)
    {
         this.nro=nro;
         this.fecha=fecha;
         this.hora=hora;
         this.codRuta=codRuta;
    }
       
}