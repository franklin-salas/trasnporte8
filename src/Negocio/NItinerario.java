package Negocio;

import Datos.DItinerario;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:25
 */
public class NItinerario {

    private DItinerario conectar;        
           
    public NItinerario() throws ClassNotFoundException{
        conectar=new DItinerario();
    }
    
    public String insertar(int nro,String fecha,String hora,String origen,String destino){
        try {
            String resultado=conectar.Insertar(nro, fecha, hora,origen, destino);
            return resultado;            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CAPA DE NEGOCIO "+e.getMessage());
            return "DATOS INCORRECTOS "+e.getMessage();
        }
    }
    
    public String actualizar(int nro,String fecha,String hora,String origen,String destino){
        String resultado=conectar.Actualizar(nro, fecha, hora, origen, destino);
        return resultado;
    }
    
    public String[] Consultabuscar(String nro){
        String[] resultado=conectar.consultasBuscar(nro);
        return resultado;
    }
    
    public String[][] ListaDeItinerarios(){
        String[][] resultado=conectar.ListaDeItinerarios();
        return resultado;
    }
    
    public String ObetenerCodigoNuevo(){
       int codigo= conectar.ObtenerCodigoMaximo()+1;
       return String.valueOf(codigo);
    }
    
    
    
        
}