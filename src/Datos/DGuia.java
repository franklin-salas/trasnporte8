package Datos;

import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:55
 */
public class DGuia {

	private int Codigo;
	private String Fecha;
	private float Costo;
	private String EstadoDeCobro;
	private int codPlanilla;
	private int codEmpleado;
	private int ciEnvia;
	private int ciRecibe;
        
        ConexionDriverSqlServer conectar;
	public DGuia() throws ClassNotFoundException{
            conectar=new ConexionDriverSqlServer();
	}

    public String Insertar(int codigo, String fecha, float costo, String estadoDeCobro,
                            int codPlanilla, int codEmpleado, int ciEnvia, int ciRecibe){
        
       try {
            conectar.conectar();
            Connection conecta=conectar.getConnection();
            CallableStatement proc = conecta.prepareCall(" EXEC AddGuia ?,?,?,?,?,?,?,? ");
            proc.setInt("codigo", codigo);
            proc.setString("fecha", fecha);
            proc.setFloat("costo",costo);
            proc.setString("estadoDeCobro",estadoDeCobro);
            proc.setInt("codPlanilla",codPlanilla);
            proc.setInt("codEmpleado",codEmpleado);
            proc.setInt("ciEnvia",ciEnvia);
            proc.setInt("ciRecibe",ciRecibe);
            proc.execute();
            conectar.desconectar();
          Bitacora.bitacora("Inserto Guia");
            return "GUIA REGISTRADA CORRECTAMENTE";
      }catch (Exception  exception) {
        return "DATOS INVALIDOS "+exception.getMessage();        
      }
    }
    
    public String[] ConsultaBuscar(String codigo){
        try {   
        ResultSet res = conectar.consulta(
          "select codigo ,fecha,costo,estadoDeCobro,codPlanilla,codEmpleado,c.ci as idEnvia,ce.ci as idRecibe"
          + " from guia,cliente c,cliente ce "
          + "where codigo="+codigo+" and (idEnvia=c.id and idRecibe=ce.id)");
        String[] v=new String[8];
        res.next();
        v[0]=String.valueOf( res.getInt("codigo"));
        v[1]=res.getString("fecha");      
        v[2]=String.valueOf(res.getFloat("costo"));
        v[3]=res.getString("estadoDeCobro");
        v[4]=String.valueOf(res.getInt("codPlanilla"));
        v[5]=String.valueOf(res.getInt("codEmpleado"));
        v[6]=String.valueOf(res.getInt("idEnvia"));
        v[7]=String.valueOf(res.getInt("idRecibe"));
        res.close();
        conectar.desconectar();
           Bitacora.bitacora("Inserto Guia");
        return v;
        }catch (Exception  exception) {
            exception.getMessage();
        }
        return null;
    }
    
    // DEVUELVE LA CANTIDAD DE TUPLAS DE LA TABLA
    public int ObtenerCodigoMaximo(){
        String consulta="select max(codigo) as cantidad from guia";
        try {   
            int cantidad=conectar.obtenerCodigoX(consulta);
            conectar.desconectar();
            return cantidad;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
            exception.getMessage();
        }
        return -1;
    }
    
    public String Actualizar(String[] datosActualizar){
       try {     
        for (int i = 0; i < datosActualizar.length; i++) {
             conectar.actualizar(datosActualizar[i]);
        }
           Bitacora.bitacora("Modifico Guia");
        return "DATOS EDITADOS CORRECTAMENTE";
      }catch (Exception  exception) {
           return exception.getMessage();        
      } 
    }
        
    // DEVUELVE UN VECTOR DE ACTUALIZACIONES PARA SQL COMO UNA CADENA EN CADA POSICION
    public String[] getDatosActualizar(int codigo, String fecha,float costo,String estadoDeCobro,
            int codPlanilla,int codEmpleado,int ciEnvia, int ciRecibe)
    {
            try {
                String v[]=new String[7];
                DCliente cliente=new DCliente();
                int codE=Integer.valueOf(cliente.ConsultaBuscar(String.valueOf(ciEnvia))[0]);
                int codR=Integer.valueOf(cliente.ConsultaBuscar(String.valueOf(ciRecibe))[0]);
                v[0]="update guia set idRecibe="+codR+ " where codigo="+codigo;
                v[1]="update guia set fecha='"+fecha+ "' where codigo="+codigo;
                v[2]="update guia set costo="+costo+ " where codigo="+codigo;
                v[3]="update guia set estadoDeCobro='"+estadoDeCobro+ "' where codigo="+codigo;
                v[4]="update guia set codPlanilla="+codPlanilla+ " where codigo="+codigo;
                v[5]="update guia set codEmpleado="+codEmpleado+ " where codigo="+codigo;
                v[6]="update guia set idEnvia="+codE+ " where codigo="+codigo;
        return v;
            }catch(ClassNotFoundException ex) {
                Logger.getLogger(DGuia.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }        
    }    
    
    public void setTodo(int Codigo, String Fecha, float Costo, String EstadoDeCobro,
    int codPlanilla, int codEmpleado, int idEnvia, int idRecibe) {
        this.Codigo = Codigo;
        this.Fecha = Fecha;
        this.Costo = Costo;
        this.EstadoDeCobro = EstadoDeCobro;
        this.codPlanilla = codPlanilla;
        this.codEmpleado = codEmpleado;
        this.ciEnvia = idEnvia;
        this.ciRecibe = idRecibe;
    }
        
        

}