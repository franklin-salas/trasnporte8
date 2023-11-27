package Negocio;

import Datos.DHojaDeLlegada;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:56:29
 */
public class NHojaDeLlegada {

    private DHojaDeLlegada conectar;

    public NHojaDeLlegada() throws ClassNotFoundException{
        conectar=new DHojaDeLlegada();
    }
    
    public String insertar(int id,String hora,String fecha,int codPlanilla){
        String resultado=conectar.Insertar(id, hora, fecha, codPlanilla);
        return resultado;
    }
    
    public String acutalizar(int id,String hora,String fecha,int codPlanilla){
        String resultado=conectar.Actualizar(conectar.getDatosActualizar(id, hora, fecha, codPlanilla, codPlanilla));
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
    
    public String[][] listaDeHojasDeLlegadas(String fecha){
        String[][] resultado=conectar.listaDeHojasDeLlegadas(fecha);
        return resultado;
    }
}