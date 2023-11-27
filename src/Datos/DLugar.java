package Datos;


import java.sql.ResultSet;
import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:35
 */
public class DLugar {

    private int cod;
    private String nombre;

    private ConexionDriverSqlServer conectar;
        
    // CONTRUCTOR QUE INICIALIZA LA CONEXION DE LA BASE DE DATOS
    public DLugar() throws ClassNotFoundException{
        conectar=new ConexionDriverSqlServer();
    }
    
    public Connection getConections() throws ClassNotFoundException{
        conectar.conectar();
        return conectar.getConnection();
    }
    
    public void desconection() throws ClassNotFoundException{
        conectar.desconectar();
    }
    
    public String Insertar(int cod, String nombre )
   {
       try {
            conectar.conectar();
            Connection conecta=conectar.getConnection();
            CallableStatement proc = conecta.prepareCall(" exec AddLugar ?,? ");
            proc.setInt("cod", cod);//Tipo entero
            proc.setString("nombre", nombre);//Tipo String
            // parametros de salida
            //proc.registerOutParameter("resultado", Types.VARCHAR);//Tipo String
            // Se ejecuta el procedimiento almacenado
            proc.execute();
            // devuelve el valor del parametro de salida del procedimiento
            conectar.desconectar();
            Bitacora.bitacora("Insertar Lugar");
            return "LUGAR REGISTRADO CORRECTAMENTE";
        }catch (Exception e) {                  
            return "DATOS INVALIDOS "+e.getMessage();
       }
       
    }
    
    public String[] ConsultaBuscar(String nombre){
        String[] v=new String[2];
        try {   
        ResultSet res = conectar.consulta("select * from lugar where nombre="+nombre);
        res.next();
        v[0]=String.valueOf( res.getInt("cod")); 
        v[1]=res.getString("nombre");
        res.close();
        conectar.desconectar();
          Bitacora.bitacora("Buscar Lugar");
        return v;
        }catch (Exception  exception) {
            return null;
        }
        
    }
    
    public String[][] ListaDeLugares(){
        try {
        ResultSet res = conectar.consulta("select * from lugar ");
        int tuplas=conectar.obtenerCodigoX("select count(cod) as cantidad from lugar ");
        String[][] v=new String[tuplas][2];
        for (int i = 0; i < v.length; i++) {
                res.next();
                 v[i][0]=String.valueOf( res.getInt("cod"));
                 v[i][1]=res.getString("nombre");
        }                         
        res.close();
        conectar.desconectar();
        return v;
        }catch (Exception  exception) {
            return null;
        }
    }
    
    // DEVUELVE LA CANTIDAD DE TUPLAS DE LA TABLA
    public int ObtenerCodigo(){
        String consulta="select max(cod) as cantidad from lugar";
        try {   
            int cantidad=conectar.obtenerCodigoX(consulta);
            conectar.desconectar();
            return cantidad;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
        return -1;
    }
    
    public String Actualizar(String[] datosActualizar){
       try {     
        for (int i = 0; i < datosActualizar.length; i++) {
             conectar.actualizar(datosActualizar[i]);
        }
        conectar.desconectar();
          Bitacora.bitacora("Modificar Lugar");
        return "DATOS ACTUALIZADOS CORRECTAMENTE";
      }catch (Exception  exception) {
          JOptionPane.showMessageDialog(null, exception.getMessage());
           return exception.getMessage();
      } 
    }
    
    // DEVUELVE UN VECTOR DE ACTUALIZACIONES PARA SQL COMO UNA CADENA EN CADA POSICION
    public String[] getDatosActualizar(int cod,String Nombre){
        String v[]=new String[1];
        v[0]="update lugar set nombre='"+Nombre+ "' where cod="+cod;
        return v;
    }
        
    //INSERTA TODOS LOS DATOS DE LA CLASE CLIENTE Y EQUIPJE
    public void setTodo(int cod,String Nombre){
         this.cod=cod;
         this.nombre=Nombre;
    }
    

}