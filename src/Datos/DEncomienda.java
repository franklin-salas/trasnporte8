package Datos;

import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:42
 */
public class DEncomienda {

	private int cod;
	private String descripcion;
	private float precio;
	private int cantidad;
        private int idGuia;
        private ConexionDriverSqlServer conectar;
        
    public DEncomienda() throws ClassNotFoundException{
        conectar =new ConexionDriverSqlServer();
    }
    
    public String Insertar(int cod, String descripcion, float precio, int cantidad,int idGuia){
       try {
            conectar.conectar();
            Connection conecta=conectar.getConnection();
            CallableStatement proc = conecta.prepareCall(" EXEC AddEncomienda ?,?,?,?,? ");
            proc.setInt("cod", cod);
            proc.setString("descripcion", descripcion);
            proc.setFloat("precio",precio);
            proc.setInt("cantidad",cantidad);
            proc.setInt("idGuia",idGuia);
            proc.execute();
            conectar.desconectar();
                Bitacora.bitacora("Inserto Encomienda");
            return "ENCOMIENDA REGISTRADA CORRECTAMENTE";
      }catch (Exception  exception) {
        return "DATOS INVALIDOS "+exception.getMessage();        
      }
    }
    
    public String[] ConsultaBuscar(String nro){
        try {
        ResultSet res = conectar.consulta("select * from encomienda where cod="+nro);
        String[] v=new String[5];
        res.next();
        v[0]=String.valueOf(res.getInt("cod"));
        v[1]=res.getString("descripcion");
        v[2]=String.valueOf(res.getFloat("precio"));
        v[3]=String.valueOf(res.getInt("cantidad"));
        v[4]=String.valueOf(res.getInt("idGuia"));
        res.close();
            Bitacora.bitacora("Busco Encomienda");
        conectar.desconectar();
        return v;
        }catch (Exception  exception) {
            exception.getMessage();
        }
        return null;
    }
    
    // DEVUELVE LA CANTIDAD DE TUPLAS DE LA TABLA
    public int ObtenerCodigoMaximo(){
        String consulta="select max(cod) as cantidad from encomienda";
        try {   
            int cantidad=conectar.obtenerCodigoX(consulta);
            conectar.desconectar();
            return cantidad;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
            exception.getMessage();
        }
        return -1;
    }
    
    public String Actualizar(String[] datosActualizar){
       try {     
        for (int i = 0; i < datosActualizar.length; i++) {
             conectar.actualizar(datosActualizar[i]);
        }
        conectar.desconectar();
            Bitacora.bitacora("Modifico Encomienda");
        return "DATOS ACTUALIZADOS CORRECTAMENTE";
      }catch (Exception  exception) {
           return exception.getMessage();        
      } 
    }
    
    // DEVUELVE UN VECTOR DE ACTUALIZACIONES PARA SQL COMO UNA CADENA EN CADA POSICION
    public String[] getDatosActualizar(){
        String v[]=new String[5];
        v[0]="update encomienda set cod="+this.cod+ " where cod="+cod;
        v[1]="update encomienda set descripcion='"+this.descripcion+ "' where cod="+cod;
        v[2]="update encomienda set precio="+this.precio+ " where cod="+cod;
        v[3]="update encomienda set cantidad="+this.cantidad+ " where cod="+cod;
        v[4]="update encomienda set idGuia="+this.idGuia+ " where cod="+cod;
        return v;        
    }
    
    public void setTodo(int cod, String descripcion, float precio, int cantidad,
        int idGuia) {
        this.cod = cod;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idGuia = idGuia;
    }
}