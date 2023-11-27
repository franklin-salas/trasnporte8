package Datos;

import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:51
 */
public class DPlanilla {

	private int cod;
	private float costoPlanilla;
	private String fecha;
	private String hora;
	private float totalPasaje;
      	private int codChofer;
	private int idVehiculo;
	private int nroItinerario;

	ConexionDriverSqlServer conectar;
    public DPlanilla() throws ClassNotFoundException{
            conectar=new ConexionDriverSqlServer();
    }
    
    public String Insertar(int cod, float costoPlanilla,String fecha,String hora,
            float totalPasaje,int nroItinerario,int codChofer, int idVehiculo){
      try {
        conectar.conectar();
        Connection conecta=conectar.getConnection();
        CallableStatement proc = conecta.prepareCall(" EXEC AddPlanilla ?,?,?,?,?,?,?,? ");  
        proc.setInt("cod",cod);
        proc.setFloat("costoPlanilla",costoPlanilla);
        proc.setString("fecha",fecha);
        proc.setString("hora",hora);
        proc.setFloat("totalPasaje",totalPasaje);
        proc.setInt("codChofer",codChofer);
        proc.setInt("idVehiculo",idVehiculo);
        proc.setInt("nroItinerario",nroItinerario);
        proc.execute();
          Bitacora.bitacora("Inserto Planilla");
        return "PLANILLA REGISTRADA CORRECTAMENTE";
      }catch (ClassNotFoundException | SQLException  exception) {
        return "DATOS INCORRECTOS "+exception.getMessage();        
      }
    }
    
    public String[] ConsultaBuscar(String cod){
        try {   
        ResultSet res = conectar.consulta("select * from planilla where cod="+cod);
        String[] v=new String[8];
        res.next();
        v[0]=String.valueOf( res.getInt("cod"));
        v[1]=String.valueOf(res.getFloat("costoPlanilla"));                 
        v[2]=res.getString("fecha");
        v[3]=res.getString("hora");
        v[4]=String.valueOf(res.getInt("totalPasaje"));
        v[5]=String.valueOf(res.getInt("codChofer"));
        v[6]=String.valueOf(res.getInt("idVehiculo"));
        v[7]=String.valueOf(res.getInt("nroItinerario"));
        res.close();
        conectar.desconectar();
     Bitacora.bitacora("Busco Planilla");
        return v;
        }catch (Exception  exception) {
            exception.getMessage();
        }
        return null;
    }
    
    // DEVUELVE LA CANTIDAD DE TUPLAS DE LA TABLA
    public int ObtenerCodigoMaximo(){
        String consulta="select max(cod) as cantidad from planilla";
        try {   
            int cantidad=conectar.obtenerCodigoX(consulta);
            return cantidad;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
        return -1;
    }
    
    public String Actualizar(String[] datosActualizar){
       try {     
        for (int i = 0; i < datosActualizar.length; i++) {
             conectar.actualizar(datosActualizar[i]);
        }
       Bitacora.bitacora("Modifico Planilla");
        return "PLANILLA ACTUALIZADA CORRECTAMENTE";
      }catch (Exception  exception) {
           return exception.getMessage();        
      } 
    }
    
    public String[][] ListaDePlanillas(String fecha){
        try {
            ResultSet res=null;
            int tuplas=0;
            res = conectar.consulta("select * from planilla where fecha='"+fecha+"'");
            tuplas=conectar.obtenerCodigoX("select count(cod) as cantidad from planilla where fecha='"+fecha+"'");
            if (tuplas==0) {
                return null;
            }
            String[][] v=new String[tuplas][14];
        for (int i = 0; i < tuplas; i++) {
            res.next();
            v[i][0]=String.valueOf(res.getInt("cod"));
            v[i][1]=String.valueOf(res.getFloat("costoPlanilla"));                 
            v[i][2]=res.getString("fecha");
            v[i][3]=res.getString("hora");
            v[i][4]=String.valueOf(res.getFloat("totalPasaje"));
            v[i][5]=String.valueOf(res.getInt("codChofer"));
            v[i][6]=String.valueOf(res.getInt("idVehiculo"));
            v[i][7]=String.valueOf(res.getInt("nroItinerario"));
        }
        res.close();
        conectar.desconectar();
        return v;
        }catch (Exception  exception) {
            //JOptionPane.showMessageDialog(null,"ERROR DE DATOS "+ exception.getMessage());
        }
        return null;
    }
        
    // DEVUELVE UN VECTOR DE ACTUALIZACIONES PARA SQL COMO UNA CADENA EN CADA POSICION
    public String[] getDatosActualizar(int cod, float costoPlanilla,String fecha,String hora,
            float totalPasaje,int nroItinerario,int codChofer, int idVehiculo)
    {
        String v[]=new String[7];
        //v[0]="update planilla set cod="+cod+ " where cod="+cod;
        v[1]="update planilla set costoPlanilla="+costoPlanilla+ " where cod="+cod;
        v[2]="update planilla set fecha='"+fecha+ "' where cod="+cod;
        v[3]="update planilla set hora='"+hora+ "' where cod="+cod;
        v[4]="update planilla set totalPasaje="+totalPasaje+ " where cod="+cod;
        v[5]="update planilla set codChofer="+codChofer+ " where cod="+cod;
        v[6]="update planilla set idVehiculo="+idVehiculo+ " where cod="+cod;
        v[0]="update planilla set nroItinerario="+nroItinerario+ " where cod="+cod;
        return v;        
    }
    
    //INSERTA TODOS LOS DATOS DE LA CLASE Persona
    public void setTodo(int cod, float costoPlanilla,String fecha,String hora,
            float totalPasaje, int idSaida,int nroItinerario,int codChofer, int idVehiculo)
    {
        this.cod=cod;
        this.costoPlanilla=costoPlanilla;
        this.fecha=fecha;
        this.hora=hora;
        this.totalPasaje=totalPasaje;
        this.nroItinerario=nroItinerario;
        this.codChofer=codChofer; 
        this.idVehiculo=idVehiculo;
    }
    
}