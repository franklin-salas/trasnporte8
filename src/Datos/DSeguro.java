package Datos;

import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:56:12
 */
public class DSeguro {

	private int cod;
	private String tipoSeguro;
        ConexionDriverSqlServer conectar;
	public DSeguro() throws ClassNotFoundException{
            conectar=new ConexionDriverSqlServer();
	}
        
//    public String Insertar(){
//      try {     
//        conectar.insertar(getInsercion());
//        return "SE INSERTO CORRECTAMENTE";
//      }catch (Exception  exception) {
//        return "DATOS INCORRECTO"+exception.getMessage().toString();        
//      }
//    }
      
     public String Insertar(int cod, String nombre )
   {
       String resultado=null;
       try {
            conectar.conectar();
            Connection conecta=conectar.getConnection();
            CallableStatement proc = conecta.prepareCall(" exec AddSeguro ?,? ");
            proc.setInt("cod", cod);//Tipo entero
            proc.setString("tipoSeguro", nombre);//Tipo String
            proc.execute();
             conectar.desconectar();
            Bitacora.bitacora("Inserto Seguro");
            return "SEGURO REGISTRADO CORRECTAMENTE";
        } 
        catch (Exception e) {                  
            //JOptionPane.showMessageDialog(null, "ERROR EN LA CAPA DE DATOS "+e.getMessage());
            return e.getMessage();
        }
   }
    
    public String[] ConsultaBuscar(String cod){
        String[] v=new String[2];
        try {   
        
        ResultSet res = conectar.consulta("select * from seguro where cod="+cod);
        res.next();
        v[0]=String.valueOf( res.getInt("cod")); 
        v[1]=res.getString("tipoSeguro");
        res.close();
        conectar.desconectar();
        Bitacora.bitacora("Busco Seguro");
        return v;
        }catch (Exception  exception) {
        
      
        }
              return null;
    }
    
    public String[][] ListaDeSeguros(){
        String[][] v=null;
        try {   
            
        ResultSet res = conectar.consulta("select * from seguro");
        int tuplas=conectar.obtenerCodigoX("select count(cod) as cantidad from seguro");
        v=new String[tuplas][2];
        for (int i = 0; i < tuplas; i++) {
            res.next();
            v[i][0]=String.valueOf( res.getInt("cod")); 
            v[i][1]=res.getString("tipoSeguro");
        }
        res.close();
        conectar.desconectar();
        return v;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CAPA DE DATOS "+exception.getMessage());
            return v;
        }
    }
    
    // DEVUELVE LA CANTIDAD DE TUPLAS DE LA TABLA
    public int ObtenerCodigoMaximo(){
        String consulta="select max(cod) as cantidad from seguro";
        try {   
     
            int cantidad=conectar.obtenerCodigoX(consulta);
            return cantidad;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
        return -1;
    }
    
    public String Actualizar(String[] datosActualizar){
       try {     
           conectar.desconectar();
        for (int i = 0; i < datosActualizar.length; i++) {
             conectar.actualizar(datosActualizar[i]);
        }
        conectar.desconectar();
        Bitacora.bitacora("modifico Seguro");
        return "DATOS EDITADOS EXITOSAMENTE";
      }catch (Exception  exception) {
           return exception.getMessage();        
      } 
    }
    
    // DEVUELVE UN VECTOR DE ACTUALIZACIONES PARA SQL COMO UNA CADENA EN CADA POSICION
    public String[] getDatosActualizar(int cod,String tipoSeguro){
        String v[]=new String[2];
        v[1]="update seguro set cod="+cod+ " where cod="+cod;
        v[0]="update seguro set tipoSeguro='"+tipoSeguro+ "' where cod="+cod;
        return v;
    }
        
    //INSERTA TODOS LOS DATOS DE LA CLASE CLIENTE Y EQUIPJE
    public void setTodo(int cod,String tipoSeguro){
         this.cod=cod;
         this.tipoSeguro=tipoSeguro;
    }
    
    //DEVUELVE UNA INSERCION EN SQL DE TIPO STRING  DE LA CLASE CLIENTE
    public String getInsercion(){
        return "insert into lugar values("+this.cod+",'"+this.tipoSeguro+"')";
    }

    public int BuscarCodigo(String text) {
        String consulta="select cod as cantidad from seguro where tipoSeguro='" +text+"'";
        try {   
            int cantidad=conectar.obtenerCodigoX(consulta);
            return cantidad;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
        return -1;
    }


}