package Negocio;

import Datos.DReserva;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:58
 */
public class NReserva {

    private DReserva conectar;
	
    public NReserva() throws ClassNotFoundException{
        conectar=new DReserva();
    }
    
    public String insertar(int id,String fecha,String hora,int codBoleto){
        String resultado=conectar.Insertar(id, fecha, hora, codBoleto);
        return resultado;
    }
    
    public String acutalizar(int id,String fecha,String hora){
        String resultado=conectar.actualizar(id, fecha,hora);
        return resultado;
    }
     
    public String[] Consultabuscar(String nroBoleto){
        String[] resultado=conectar.ConsultaBuscar(nroBoleto);
        return resultado;
    }
    
    public String ObetenerCodigoNuevo(){
       int codigo= conectar.ObtenerCodigoMaximo()+1;
       return String.valueOf(codigo);
    }
    
    public String[][] ListaDeReservas(String fecha){
        String[][] resultado=conectar.ListaDeReservas(fecha);
        return resultado;
    }

}