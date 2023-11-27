package Negocio;

import Datos.DEncomienda;
import java.sql.ResultSet;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:42
 */
public class NEncomienda {

    private DEncomienda conectar;
    
    public NEncomienda() throws ClassNotFoundException{
        conectar=new DEncomienda();
    }
    
    public String insertar(int cod, String descripcion, float precio, int cantidad,
        int idGuia){
        String insertado=conectar.Insertar(cod, descripcion, precio, cantidad, idGuia);
        return insertado;
    }
    
    public String acutalizar(int cod, String descripcion, float precio, int cantidad,
        int idGuia){
       String resultado=conectar.Actualizar(conectar.getDatosActualizar());
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
}