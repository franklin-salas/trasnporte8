package Negocio;

import Datos.DCliente;
import Datos.DGuia;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:55
 */
public class NGuia {

    private DGuia conectar;
    public NGuia() throws ClassNotFoundException{
        conectar=new DGuia();
    }
    
    public String insertar(int Codigo, String Fecha, float Costo, String EstadoDeCobro,
    int codPlanilla, int codEmpleado, int ciEnvia, int ciRecibe){
        conectar.setTodo(Codigo, Fecha, Costo, EstadoDeCobro, codPlanilla, codEmpleado, ciEnvia, ciRecibe);
        String insertado=conectar.Insertar(Codigo, Fecha, Costo, EstadoDeCobro, codPlanilla, codEmpleado, ciEnvia, ciRecibe);
        return insertado;
    }
    
    public String acutalizar(int Codigo, String Fecha, float Costo, String EstadoDeCobro,
    int codPlanilla, int codEmpleado, int idEnvia, int idRecibe){
       String resulado=conectar.Actualizar(conectar.getDatosActualizar(Codigo, Fecha, Costo, EstadoDeCobro, codPlanilla, codEmpleado, idEnvia, idRecibe));
       return resulado;
    }

    public String[] Consultabuscar(String cod){
        String[] resultado=conectar.ConsultaBuscar(cod);
        return resultado;
    }
    
    public String GenerarCodigo(){
       int codigo= conectar.ObtenerCodigoMaximo()+1;
       return String.valueOf(codigo);
    }

}