package Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:56:29
 */
public class DEstado {
    
    private int id;
    private String descripcion;
    private String habilitado;

    private ConexionDriverSqlServer conectar;
    public DEstado() throws ClassNotFoundException{
        conectar=new ConexionDriverSqlServer();
    }
    
    public Connection getConections() throws ClassNotFoundException{
        conectar.conectar();
        return conectar.getConnection();
    }
    
    public void desconection() throws ClassNotFoundException{
        conectar.desconectar();
    }
    
    public String procedure(int cod, String nombre )
   {
       try {
            conectar.conectar();
            Connection conecta=conectar.getConnection();
            CallableStatement proc = conecta.prepareCall(" exec AddEstado ?,?,? ");
            proc.setInt("id", cod);//Tipo entero
            proc.setString("descripcion", nombre);//Tipo String
            proc.setString("habilitado", nombre);//Tipo String
            proc.execute();
            conectar.desconectar();
           Bitacora.bitacora("Inserto Estado");
            return "ESTADO REGISTRADO CORRECTAMENTE";
        } 
       catch (Exception e) {                  
            return "DATOS INVALIDOS "+e.getMessage();
       }
       
   }
    
    public String Insertar(){
      try {     
        conectar.insertar(getInsercion());
        desconection();
        return "SE REGISTRO CORRECTAMENTE";
      }catch (Exception  exception) {
        return "DATOS INCORRECTO"+exception.getMessage().toString();        
      }
    }
    
    public String[] ConsultaBuscar(String cod){
        String[] v=new String[3];
        try {   
        ResultSet res = conectar.consulta("select * from estado where id="+cod);
        res.next();
        v[0]=String.valueOf( res.getInt("id")); 
        v[1]=res.getString("descripcion");
        v[2]=res.getString("habilitado");
        res.close();
      Bitacora.bitacora("Busco Estado");
        conectar.desconectar();
        return v;
        }catch (Exception  exception) {
        
     
        }
    return  null;
    }
    
    public String[][] ListaDeLugares(){
        try {   
        // lo unico cambia en el siguiente reglon sera la el nombre de tu tabla y tus atribustos si son mas de uno
        ResultSet res = conectar.consulta("select * from estado ");
        int tuplas=conectar.obtenerCodigoX("select count(id) as cantidad from estado ");
        String[][] v=new String[tuplas][3];
        for (int i = 0; i < v.length; i++) {
                res.next();
                 v[i][0]=String.valueOf( res.getInt("id"));
                 v[i][1]=res.getString("descripcion");
                 v[i][2]=res.getString("habilitado");
        }                         
        res.close();
        conectar.desconectar();
        return v;
        }catch (Exception  exception) {
            exception.getMessage();
        }
        return null;
    }
    
    // DEVUELVE LA CANTIDAD DE TUPLAS DE LA TABLA
    public int ObtenerCodigo(){
        String consulta="select max(id) as cantidad from estado";
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
     Bitacora.bitacora("Modifico Estado");
        return "DATOS ACTUALIZADOS CORRECTAMENTE";
      }catch (Exception  exception) {
          JOptionPane.showMessageDialog(null, exception.getMessage());
           return exception.getMessage();        
      } 
    }
    
    // DEVUELVE UN VECTOR DE ACTUALIZACIONES PARA SQL COMO UNA CADENA EN CADA POSICION
    public String[] getDatosActualizar(int id,String descripcion,String habilitado){
        String v[]=new String[2];
        v[0]="update estado set descripcion='"+descripcion+ "' where id="+id;
        v[1]="update estado set habilitado='"+habilitado+ "' where id="+id;
        return v;
    }
        
    //INSERTA TODOS LOS DATOS DE LA CLASE CLIENTE Y EQUIPJE
    public void setTodo(int id,String descripcion,String habilitado){
         this.id=id;
         this.descripcion=descripcion;
         this.habilitado=habilitado;
    }
    
    //DEVUELVE UNA INSERCION EN SQL DE TIPO STRING  DE LA CLASE CLIENTE
    public String getInsercion(){
        return "insert into estado values("+this.id+",'"+this.descripcion+"','"+this.habilitado+"')";
    }
	
}