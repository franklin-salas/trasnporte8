package Negocio;


import Datos.DLugar;
import java.sql.ResultSet;
/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:35
 */
public class NLugar {

    private DLugar conectar;    
    
    // CONTRUCTOR QUE INICIALIZA LA CONEXION DE LA BASE DE DATOS
    public NLugar() throws ClassNotFoundException{
        conectar=new DLugar();
    }
    

    public String insertar(int cod,String Nombre){
        String resultado=conectar.Insertar(cod, Nombre);
        return resultado;
    }
    
    public String acutalizar(int cod,String Nombre){
        String resultado=conectar.Actualizar(conectar.getDatosActualizar(cod, Nombre));
        return resultado;
    }
     
    public String[] Consultabuscar(String nombre){
        String[] resultado=conectar.ConsultaBuscar("'"+nombre+"'");
        return resultado;
    }
    
    public String ObetenerCodigo(){
       int codigo= conectar.ObtenerCodigo()+1;
       return String.valueOf(codigo);
    }

    public String[][] ListaDeLugares() {
        String[][] resultado=conectar.ListaDeLugares();
        return resultado;
    }

}