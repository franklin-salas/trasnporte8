package Datos;

import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:01
 */
public class DHojaDeSalida {

	private int id;
	private float costo;
	private String hora;
        private int codPlanilla;
        
        ConexionDriverSqlServer conectar;
	public DHojaDeSalida() throws ClassNotFoundException{
            conectar=new ConexionDriverSqlServer();
	}
    
    public String Insertar(int id,String hora,float costo,int codPlanilla){
       try {
            conectar.conectar();
            Connection conecta=conectar.getConnection();
            CallableStatement proc = conecta.prepareCall(" EXEC AddHojaDeSalida ?,?,?,?");
            proc.setInt("id", id);
            proc.setFloat("costo", costo);
            proc.setString("hora",hora);
            proc.setInt("codPlanilla",codPlanilla);
            proc.execute();
            conectar.desconectar();
     Bitacora.bitacora("Inserto hoja de salida");
            return "HOJA DE SALIDA REGISTRADA CORRECTAMENTE";
      }catch (Exception  exception) {
        return "DATOS INVALIDOS "+exception.getMessage();        
      }
    }
    
    public String[] ConsultaBuscar(String id){
        String[] v=new String[4];
        try {   
        ResultSet res = conectar.consulta("select * from hojaDeSalida where id="+id);
        res.next();
        v[0]=String.valueOf( res.getInt("id")); 
        v[1]=String.valueOf( res.getInt("costo")); 
        v[2]=res.getString("hora");
        v[3]=String.valueOf( res.getInt("codPlanilla")); 
        res.close();
        conectar.desconectar();
        Bitacora.bitacora("Busco hoja  de Salida");
        return v;
        }catch (Exception  exception) {
            v[0]=exception.getMessage().toString();
            return v;
        }
        
    }
    
    // DEVUELVE LA CANTIDAD DE TUPLAS DE LA TABLA
    public int ObtenerCodigoMaximo(){
        String consulta="select max(id) as cantidad from hojaDeSalida";
        try {   
            int cantidad=conectar.obtenerCodigoX(consulta);
            return cantidad;
        }catch (Exception  exception) {
            //JOptionPane.showMessageDialog(null, "ERROR DEL SISTEMA"+exception.getMessage());
        }
        return -1;
    }
    
    public String Actualizar(String[] datosActualizar){
       try {     
        for (int i = 0; i < datosActualizar.length; i++) {
             conectar.consulta(datosActualizar[i]);
        }
       Bitacora.bitacora("Modifico hoja de Salida");
        return "SE ACTUALIZO CORRECTAMENTE";
      }catch (Exception  exception) {
           return exception.getMessage();        
      }
    }
    
    public String[] getDatosActualizar(int id,float costo,String hora,int codPlanilla){
        String v[]=new String[3];
        v[0]="update hojaDeSalida set costo="+costo+ " where id="+id;
        v[1]="update hojaDeSalida set hora='"+hora+ "' where id="+id;
        v[2]="update hojaDeSalida set codPlanilla="+codPlanilla+" where id="+id;
        return v;
    }
    
    //INSERTA TODOS LOS DATOS DE LA CLASE CLIENTE Y EQUIPJE
    public void setTodo(int id,float costo,String hora,int codPlanilla)
    {
         this.id=id;
         this.costo=costo;
         this.hora=hora;
         this.codPlanilla=codPlanilla;
    }
    
    public String[][] listaDeHojasDeSalidas(String fecha) {
        try {   
        ResultSet res = conectar.consulta("select h.id,h.costo,h.hora,h.codPlanilla "
           + "from hojaDeSalida h,planilla p where p.fecha='"+fecha+"' and h.codPlanilla=p.cod");
        int tuplas=conectar.obtenerCodigoX("select count(id) as cantidad "
           + "from hojaDeSalida h,planilla p where p.fecha='"+fecha+"' and h.codPlanilla=p.cod");
        String[][] v=new String[tuplas][4];
        for (int i = 0; i < tuplas; i++) {
            res.next();
            v[i][0]=String.valueOf( res.getInt("id")); 
            v[i][1]=res.getString("costo"); 
            v[i][2]=res.getString("hora");
            v[i][3]=String.valueOf( res.getInt("codPlanilla")); 
        }       
        res.close();
        conectar.desconectar();
        return v;
        }catch (Exception  exception) {
            return null;
        }
    }
        
        

}