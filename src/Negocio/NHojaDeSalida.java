package Negocio;

import Datos.DHojaDeSalida;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:01
 */
public class NHojaDeSalida {

    private DHojaDeSalida conectar;
    public NHojaDeSalida() throws ClassNotFoundException{
        conectar=new DHojaDeSalida();
    }

    public String insertar(int id,float costo,String hora,int codPlanilla){
        String resultado=conectar.Insertar(id, hora, costo, codPlanilla);
        return resultado;
    }
    
    public String acutalizar(int id,float costo,String hora,int codPlanilla){
        String resultado=conectar.Actualizar(conectar.getDatosActualizar(id, costo, hora, codPlanilla));
        return resultado;
    }
     
    public String[] Consultabuscar(String id){
        String[] resultado=conectar.ConsultaBuscar(id);
        return resultado;
    }
    
    public String ObetenerCodigoNuevo(){
       int codigo= conectar.ObtenerCodigoMaximo()+1;
       return String.valueOf(codigo);
    }
    
    public String[][] listaDeHojasDeSalidas(String fecha){
        String[][] resultado=conectar.listaDeHojasDeSalidas(fecha);
        return resultado;
    }
    
}