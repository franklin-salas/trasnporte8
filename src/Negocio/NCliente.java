package Negocio;


import Datos.DCliente;
import Entidad.Cliente;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:35
 */
public class NCliente {

    private DCliente conectar;
    public NCliente() throws ClassNotFoundException{
        conectar=new DCliente();
    }
    
    public String insertar(int ID,int CI,String Nombre,String Sexo){
        String resultado= conectar.Insertar(ID, CI, Nombre, Sexo);
        return resultado;
    }
    
    public String actualizar(int ID,int CI,String Nombre,String Sexo){
        String resultado=conectar.Actualizar(conectar.getDatosActualizar(ID,CI, Nombre, Sexo));
        return resultado;
    }
     
    public String[] Consultabuscar(String carnet){
        String[] resultado=conectar.ConsultaBuscar(carnet);
        return resultado;
    }
    
    public String ObetenerCodigo(){
       int codigo= conectar.ObtenerCodigoMaximo()+1;
       return String.valueOf(codigo);
    }

     public  static Cliente buscarConCI(int Ci){
        Cliente c=null;
         try {
                      
            DCliente  cliente= new DCliente();
            c =cliente.buscar(Ci);
            if(c==null){
                JOptionPane.showMessageDialog(null, "Cliente: No se Encontro", "Cliente", JOptionPane.INFORMATION_MESSAGE);
            }
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(NCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            return c;
        
    }
    public String[][] ListaDeClientes() {
        String[][] resultado=conectar.ListaDeClientes();
        return resultado;
    }
	public static  Cliente buscarConID(int id){
            Cliente c=null;
        try {
            DCliente  cliente= new DCliente();
            
            
            c =  cliente.buscarPorID(id);
            if(c==null){
                JOptionPane.showMessageDialog(null, "Cliente: No se Encontro", "Cliente", JOptionPane.INFORMATION_MESSAGE);
            }
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
     return c;
}
}