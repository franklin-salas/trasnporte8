package Negocio;

import Datos.DSeguro;
import javax.swing.JOptionPane;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:56:12
 */
public class NSeguro {

    private DSeguro conectar;

    public NSeguro() throws ClassNotFoundException{
        conectar=new DSeguro();
    }
    
    public String insertar(int cod,String tipoSeguro){
        String insertado=conectar.Insertar(cod, tipoSeguro);
        return insertado;
    }
    
    public String acutalizar(int cod,String tipoSeguro){
        String resultado=conectar.Actualizar(conectar.getDatosActualizar(cod, tipoSeguro));
        return resultado;
    }
     
    public String[] Consultabuscar(String cod){
        String[] resultado=conectar.ConsultaBuscar(cod);
        return resultado;
    }
    
    public String[][] ListaDeSeguro(){
        String[][] resultado=conectar.ListaDeSeguros();
        return resultado;
    }
    
    public int ObetenerCodigoNuevo(){
       int codigo= conectar.ObtenerCodigoMaximo()+111;
       return codigo;
    }

    public int obtenerCodigo(String text) {
        int codigo=conectar.BuscarCodigo(text);
        if (codigo==-1) {
            JOptionPane.showMessageDialog(null, "EL CODIGO NO EXISTE");
        }
        return codigo;
    }

}