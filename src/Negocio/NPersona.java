package Negocio;


import Datos.DPersona;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:43
 */
public class NPersona {
    
    private DPersona conectar;
        
    // CONTRUCTOR QUE INICIALIZA LA CONEXION DE LA BASE DE DATOS
    public NPersona() throws ClassNotFoundException{
        conectar=new DPersona();
    }

    public String insertar(int cod, int ci,String nombre,String sexo,String dir,
            int telf,String habilitado,int nroInterno,String categoria,String cargo,
            String tSocio,String tChofer,String tEmpleado,String disponible)
    {   
        String insertado=conectar.Insertar(cod,ci, nombre, sexo, dir,telf, habilitado,
                nroInterno, categoria, cargo,tSocio, tChofer, tEmpleado, disponible);
        return insertado;
    }
    
    public String acutalizar(int cod, int ci,String nombre,String sexo,String dir,
            int telf,String habilitado,int nroInterno,String categoria,String cargo,
            String tSocio,String tChofer,String tEmpleado,String disponible)
    {
        String resultado= conectar.Actualizar(conectar.getDatosActualizar(cod, ci, nombre, sexo, dir, telf, 
            nroInterno, categoria, cargo, tSocio, tChofer, tEmpleado, disponible, habilitado));
        return resultado;
    }
     
    public String[] Consultabuscar(String carnet){
        String[] resultado=conectar.ConsultaBuscar(carnet);
        return resultado;
    }
    
    public String ObetenerCodigoNuevo(){
       int codigo= conectar.ObtenerCodigoMaximo()+1;
       return String.valueOf(codigo);
    }
    
    public String ObetenerNroIntNuevo(){
       int codigo= conectar.ObtenerNroIntMaximo()+1;
       return String.valueOf(codigo);
    }

    public String[][] listaDePersonas(String tipo){
        String[][] resultado =conectar.ListaDePersonas(tipo);
        return resultado;
    }
}