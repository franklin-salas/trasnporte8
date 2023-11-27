package Negocio;


import Datos.ConexionDriverSqlServer;
import Datos.DBoleto;

/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:22
 */
public class NBoleto {
    private DBoleto conectar;
	
    public NBoleto() throws ClassNotFoundException{
            conectar=new DBoleto();
    }
        
    public String insertar(int Nro,float precio,int asiento,int codplanilla,int codPersona,int ciCliente){
        String resultado=conectar.Insertar(Nro, precio, asiento, codplanilla, codPersona, ciCliente);
        return resultado;
    }
    
    public String acutalizar(int Nro,float precio,int codAsiento,int codplanilla,int codPersona,int ciCliente){
        String resultado=conectar.Actualizar(conectar.getDatosActualizar(Nro, precio, 
                codAsiento, codplanilla, codPersona, ciCliente));
        return resultado;
    }
     
    public String[] Consultabuscar(String nro){
        String[] resultado=conectar.ConsultaBuscar(nro);
        return resultado;
    }
    
    public String ObetenerCodigoNuevo(){
       int codigo= conectar.ObtenerCodigoMaximo()+1;
       return String.valueOf(codigo );
    }

    public String[][] listaDeBoletos(String fecha) {
        String[][] resultado=conectar.listaDeBoletos(fecha);
        return resultado;
    }
}