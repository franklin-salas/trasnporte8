package Negocio;

import Datos.DRuta;
import java.sql.ResultSet;

/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:56:05
 */
public class NRuta {
    
    private DRuta conectar;
    
    public NRuta() throws ClassNotFoundException{
        conectar=new DRuta();
    }
    
    public String insertar(int cod,float costo,String tiempoDeViaje,String codOrigen,String codDestino){
        String resultado=conectar.Insertar(cod, costo, tiempoDeViaje, codOrigen, codDestino);
        return resultado;
    }
    
    public String actualizar(int cod,float costo,String tiempoDeViaje,String codOrigen,String codDestino){
        String resultado=conectar.Actualizar(cod, costo, tiempoDeViaje, codOrigen, codDestino);
        return resultado;
    }
     
    public String[] Consultabuscar(String cod){
        String[] resultado=conectar.ConsultaBuscar(cod);
        return resultado;
    }
    
    public String ObetenerCodigoNuevo(){
       int codigo= conectar.ObtenerCodigoMaximo()+1;
       return String.valueOf(codigo);
    }

    public String[][] ListaDeRutas(){
        String[][] resultado=conectar.ListaDeRutas();
        return resultado;
    }
}