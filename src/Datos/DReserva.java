package Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:58
 */
public class DReserva {

    private int ID;
    private String Fecha;
    private String Hora;
    private ConexionDriverSqlServer conectar;
    public DReserva() throws ClassNotFoundException{
        conectar=new ConexionDriverSqlServer();
    }
    
    public String Insertar(int id,String fecha,String hora,int codBoleto){
      try {
            conectar.conectar();
            Connection conecta=conectar.getConnection();
            CallableStatement proc = conecta.prepareCall(" exec AddReserva ?,?,?,? ");
            proc.setInt("id", id);
            proc.setString("fecha", fecha);
            proc.setTime("hora", Time.valueOf(hora));
            proc.setInt("codBoleto", codBoleto);
            proc.execute();
            conectar.desconectar();
          Bitacora.bitacora("Inserto Reserva");
            return "RESERVA REGISTRADA CORRECTAMENTE";
        } 
       catch (Exception e) {                  
            return "DATOS INVALIDOS "+e.getMessage();
       }
    }
    
    public String[] ConsultaBuscar(String nroBoleto){
        String[] v=new String[4];
        try {   
        ResultSet res = conectar.consulta("select * from reserva where nroBoleto="+nroBoleto);
        res.next();
        v[0]=String.valueOf( res.getInt("id")); 
        v[1]=res.getString("fecha");
        v[2]=String.valueOf(res.getTime("hora"));
        v[3]=String.valueOf(res.getInt("nroBoleto")); 
        res.close();
        conectar.desconectar();
        Bitacora.bitacora("Busco Reserva");
        return v;
        }catch (Exception  exception) {
            return null;
        }        
    }
    
    public String[][] ListaDeReservas(String fecha){
        String[][] v;
        try {   
        ResultSet res = conectar.consulta("select * from reserva where fecha="+fecha);
        int tuplas=conectar.obtenerCodigoX("select count(id) as cantidad from reserva");
        v=new String[tuplas][4];
        for (int i = 0; i < tuplas; i++) {
            res.next();
            v[i][0]=String.valueOf( res.getInt("id")); 
            v[i][1]=res.getString("fecha");
            v[i][2]=String.valueOf(res.getTime("hora"));
            v[i][3]=String.valueOf(res.getInt("nroBoleto"));
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
        String consulta="select max(id) as cantidad from reserva";
        try {   
            int cantidad=conectar.obtenerCodigoX(consulta);
            conectar.desconectar();
            return cantidad;
        }catch (Exception  exception) {
        //    JOptionPane.showMessageDialog(null, "ERROR DEL SISTEMA"+exception.getMessage());
        }
        return -1;
    }    

    public String actualizar(int id,String fecha,String hora){
      try {
            conectar.actualizar("update reserva set fecha='"+fecha+"' where id="+id);
            conectar.actualizar("update reserva set hora='"+hora+"' where id="+id);
           Bitacora.bitacora("Modifico Reserva");
            return "RESERVA ACTUALIZADA CORRECTAMENTE";
      }catch (Exception e){
            return "DATOS INVALIDOS "+e.getMessage();
      }
    }
    
    public void setTodo(int ID, String Fecha, String Hora) {
        this.ID = ID;
        this.Fecha = Fecha;
        this.Hora = Hora;
    }
        
}