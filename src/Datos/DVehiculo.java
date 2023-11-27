package Datos;

import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:56:23
 */
public class DVehiculo {

	private int id;
	private String Placa;
	private int Capacidad;
	private String Tipo;
	private int Modelo;
	private int codPersona;
	private int idEstado;
        
        private int codSoat;
	private int codCredinform;
	private int anio;

        ConexionDriverSqlServer conectar;
	public DVehiculo() throws ClassNotFoundException{
            conectar=new ConexionDriverSqlServer();
	}
    
    public String Insertar(int id,String placa,int capacidad,String tipo,int modelo, int codPersona,
            int idEstado,int codSoat,String otroSeguro,int anio){
      try {
        conectar.conectar();
        Connection conecta=conectar.getConnection();
        CallableStatement proc = conecta.prepareCall(" EXEC AddVehiculo ?,?,?,?,?,?,?,?,?,? ");  
        proc.setInt("id",id);
        proc.setString("placa",placa);
        proc.setInt("capacidad",capacidad);
        proc.setString("tipo",tipo);
        proc.setInt("modelo",modelo);
        proc.setInt("codPersona",codPersona);
        proc.setInt("idEstado",idEstado);
        proc.setInt("codSoat",codSoat);
        proc.setString("otroSeguro",otroSeguro);
        proc.setInt("anio",anio);
        proc.execute();
        conectar.desconectar();
      Bitacora.bitacora("Inserto Vehiculo");
        return "VEHICULO REGISTRADO CORRECTAMENTE";
      }catch (ClassNotFoundException | SQLException  exception) {
        return "DATOS INVALIDOS "+exception.getMessage();        
      }
    }
    
    public String[] ConsultaBuscar(String placa, String anio){
        String[] v=new String[0];
        try {   
        ResultSet res = conectar.consulta("select * from vehiculo where placa='"+placa+"'");
        v=new String[11];
        res.next();
        v[0]=String.valueOf(res.getInt("id"));
        v[1]=res.getString("placa");
        v[2]=String.valueOf(res.getInt("capacidad"));
        v[3]=res.getString("tipo");
        v[4]=String.valueOf( res.getInt("modelo"));
        v[5]=String.valueOf( res.getInt("codSocio"));
        v[6]=String.valueOf( res.getInt("idEstado"));
        res.close();
        placa=v[0];
        conectar.desconectar();
        res = conectar.consulta("select * from vehiculoSeguro where idvehiculo="+placa + " and anio="+anio);
        res.next();
        v[7]=String.valueOf(res.getInt("codSeguro"));
        v[8]=String.valueOf(res.getInt("anio"));
        res.next();
        v[9]=String.valueOf(res.getInt("codSeguro"));
        v[10]=String.valueOf(res.getInt("anio"));
        res.close();
        conectar.desconectar();
         Bitacora.bitacora("Busco Vehiculo");
        return v;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null,"ERROR EN LA CONEXION "+ exception.getMessage());
            return null;
        }        
    }
    
    // DEVUELVE LA CANTIDAD DE TUPLAS DE LA TABLA
    public int ObtenerCodigoMaximo(){
        String consulta="select max(id) as cantidad from vehiculo";
        try {   
            int cantidad=conectar.obtenerCodigoX(consulta);
            return cantidad;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
            exception.getMessage();
        }
        return -1;
    }
    
    public String Actualizar(int id,String placa,int capacidad,String tipo,int modelo, int codPersona,
            int idEstado,int codSoat,String otroSeguro,int anio){
       try {
        conectar.conectar();
        Connection conecta=conectar.getConnection();
        CallableStatement proc = conecta.prepareCall(" EXEC updateVehiculo ?,?,?,?,?,?,?,?,?,? ");  
        proc.setInt("id",id);
        proc.setString("placa",placa);
        proc.setInt("capacidad",capacidad);
        proc.setString("tipo",tipo);
        proc.setInt("modelo",modelo);
        proc.setInt("codPersona",codPersona);
        proc.setInt("idEstado",idEstado);
        proc.setInt("codSoat",codSoat);
        proc.setString("otroSeguro",otroSeguro);
        proc.setInt("anio",anio);
        proc.execute();
        conectar.desconectar();
    Bitacora.bitacora("Modifico Vehiculo");
        return "VEHICULO ACTUALIZADO CORRECTAMENTE";
      }catch (ClassNotFoundException | SQLException  exception) {
        return "DATOS INVALIDOS "+exception.getMessage();
      }
    }
    
    //INSERTA TODOS LOS DATOS DE LA CLASE CLIENTE Y EQUIPJE
    public void setTodo(int id,String placa,int capacidad,String tipo,int modelo, int codPersona,int idEstado,
    int codSoat,int codCredinform,int anio){
        this.id=id;
	this.Placa=placa;
	this.Capacidad=capacidad;
	this.Tipo=tipo;
	this.Modelo=modelo;
	this.codPersona=codPersona;
	this.idEstado=idEstado;
        
        this.codSoat=codSoat;
	this.codCredinform=codCredinform;
	this.anio=anio;
    }
        
    public String[][] listaDeVehiculos() {
        try {   
        // lo unico cambia en el siguiente reglon sera la el nombre de tu tabla y tus atribustos si son mas de uno
        ResultSet res = conectar.consulta("select * from vehiculo ");
        int tuplas=conectar.obtenerCodigoX("select count(id) as cantidad from vehiculo ");
        String[][] v=new String[tuplas][7];
        for (int i = 0; i < v.length; i++) {
                res.next();
                 v[i][0]=String.valueOf( res.getInt("id"));
                 v[i][1]=res.getString("placa");
                 v[i][2]=String.valueOf( res.getInt("capacidad"));
                 v[i][3]=res.getString("tipo");
                 v[i][4]=String.valueOf(res.getInt("modelo"));
                 v[i][5]=String.valueOf(res.getInt("codSocio"));
                 v[i][6]=String.valueOf(res.getInt("idEstado"));
        }                         
        res.close();
        conectar.desconectar();
        return v;
        }catch (Exception  exception) {
            exception.getMessage();
        }
        return null;
    }
}