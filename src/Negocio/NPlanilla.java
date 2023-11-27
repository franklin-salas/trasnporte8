package Negocio;

import Datos.DPlanilla;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:51
 */
public class NPlanilla {

    private DPlanilla conectar;
    public NPlanilla() throws ClassNotFoundException{
        conectar=new DPlanilla();
    }
        
    public String insertar(int cod, float costoPlanilla,String fecha,String hora,
            float totalPasaje,int nroItinerario,int codChofer, int idVehiculo)
    {
        String resultado= conectar.Insertar(cod, costoPlanilla, fecha, hora, totalPasaje, 
                                            nroItinerario, codChofer, idVehiculo);
        return resultado;
    }
    
    public String actualizar(int cod, float costoPlanilla,String fecha,String hora,
            float totalPasaje,int nroItinerario,int codChofer, int idVehiculo){
       String resultado= conectar.Actualizar(conectar.getDatosActualizar(cod, costoPlanilla, fecha, hora, totalPasaje, nroItinerario, codChofer, idVehiculo));
       return resultado;
    }
     
    public String[] Consultabuscar(String nro){
        String[] resultado=conectar.ConsultaBuscar(nro);
        return resultado;
    }
    
    public String ObetenerCodigoNuevo(){
       int codigo= conectar.ObtenerCodigoMaximo()+1;
       return String.valueOf(codigo);
    }

    public String[][] ListaDeItinerarios(String fecha) {
        String[][] resultado=conectar.ListaDePlanillas(fecha);
        return resultado;
    }

}