package Negocio;

import Datos.DSeguro;
import Datos.DVehiculo;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:56:23
 */
public class NVehiculo {

    private DVehiculo conectar;

    public NVehiculo() throws ClassNotFoundException{
         conectar=new DVehiculo();
    }
    
    public String insertar(int id,String placa,int capacidad,String tipo,int modelo, int codPersona,int idEstado,
    int codSoat,String otroSeguro,int anio){
        String resultado= conectar.Insertar
        (id, placa, capacidad, tipo, modelo, codPersona, idEstado, codSoat, otroSeguro, anio);
        return resultado;
    }
    
    public String acutalizar(int id,String placa,int capacidad,String tipo,int modelo, int codPersona,int idEstado,
    int codSoat,String otroSeguro,int anio){
        String resultado=conectar.Actualizar
        (id, placa, capacidad, tipo, modelo, codPersona, idEstado, codSoat, otroSeguro, anio);
        return resultado;
    }
     
    public String[] Consultabuscar(String placa,String anio){
        String[] resultado=conectar.ConsultaBuscar(placa, anio);
        return resultado;
    }
    
    public String[][] listaDeVehiculos(){
        String[][] lista=conectar.listaDeVehiculos();
        return lista;
    }
    
    public String ObetenerCodigoNuevo(){
       int codigo= conectar.ObtenerCodigoMaximo()+1;
       return String.valueOf(codigo);
    }
}