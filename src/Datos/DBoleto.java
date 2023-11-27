package Datos;


import java.sql.CallableStatement;
import java.sql.Types;
import Datos.ConexionDriverSqlServer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:22
 */
public class DBoleto {

	private int Nro;
	private float precio;
	private int asiento;
	private int codplanilla;
	private int codPersona;
	private int IdCliente;

        private ConexionDriverSqlServer conectar;
	
        public DBoleto() throws ClassNotFoundException{
            conectar=new ConexionDriverSqlServer();
	}
    
    public String Insertar(int Nro,float precio,int asiento,
                           int codplanilla,int codPersona,int ciCliente){
        
       try {
            conectar.conectar();
            Connection conecta=conectar.getConnection();
            CallableStatement proc = conecta.prepareCall(" EXEC AddBoleto ?,?,?,?,?,? ");
            proc.setInt("nro", Nro);//Tipo entero
            proc.setFloat("precio", precio);//Tipo String
            proc.setInt("asiento",asiento);//Tipo String
            proc.setInt("codPlanilla",codplanilla);//Tipo String
            proc.setInt("codEmpleado",codPersona);//Tipo String
            proc.setInt("ciCliente",ciCliente);//Tipo String
            proc.execute();
                Bitacora.bitacora("Inserto Boleto");
            conectar.desconectar();
            return "CLIENTE REGISTRADO CORRECTAMENTE";
      }catch (Exception  exception) {
        return "DATOS INVALIDOS "+exception.getMessage();        
      }
    }
    
    public String[] ConsultaBuscar(String nro){
        try {
        ResultSet res = conectar.consulta("select nro,precio,asiento,codPlanilla,codEmpleado,ci "
                + "from boleto, cliente where idCliente=id and Nro="+nro);
        String[] v=new String[6];
        res.next();
        v[0]=String.valueOf(res.getInt("nro"));
        v[1]=String.valueOf(res.getInt("precio"));                 
        v[2]=String.valueOf(res.getInt("asiento"));
        v[3]=String.valueOf(res.getInt("codPlanilla"));
        v[4]=String.valueOf(res.getInt("codEmpleado"));
        v[5]=String.valueOf(res.getInt("ci"));
        res.close();
        conectar.desconectar();
            Bitacora.bitacora("Busco Boleto");
        return v;
        }catch (Exception  exception) {
            exception.getMessage();
        }
        return null;
    }
    
    // DEVUELVE LA CANTIDAD DE TUPLAS DE LA TABLA
    public int ObtenerCodigoMaximo(){
        String consulta="select max(nro) as cantidad from boleto";
        try {   
            int cantidad=conectar.obtenerCodigoX(consulta);
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
        
        conectar.desconectar();
            Bitacora.bitacora("Modifico Boleto");
        return "DATOS ACTUALIZADOS CORRECTAMENTE";
      }catch (Exception  exception) {
           return exception.getMessage();        
      } 
    }
    
    // DEVUELVE UN VECTOR DE ACTUALIZACIONES PARA SQL COMO UNA CADENA EN CADA POSICION
    public String[] getDatosActualizar(int Nro,float precio,int asiento,int codplanilla,int codPersona,int IdCliente){
        String v[]=new String[5];
            try {
                DCliente cliente=new DCliente();
                int id=Integer.valueOf(cliente.ConsultaBuscar(String.valueOf(IdCliente))[0]);
                v[0]="update boleto set IdCliente="+id+ " where nro="+Nro;
                v[1]="update boleto set precio="+precio+ " where nro="+Nro;
                v[2]="update boleto set asiento="+asiento+ " where nro="+Nro;
                v[3]="update boleto set codplanilla="+codplanilla+ " where nro="+Nro;
                v[4]="update boleto set codEmpleado="+codPersona+ " where nro="+Nro;
                return v;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBoleto.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
                
    }
        
    public void setTodos(int Nro,float precio,int codAsiento,
    int codplanilla,int codPersona,int IdCliente)
    {
        this.Nro=Nro;
        this.precio=precio;
        this.asiento=codAsiento;
        this.codplanilla=codplanilla;
        this.codPersona=codPersona;
        this.IdCliente=IdCliente;        
    }

    public String[][] listaDeBoletos(String fecha) {
        try {
        ResultSet res = conectar.consulta(
        "select b.nro,b.precio,b.asiento,b.codPlanilla,b.codEmpleado,c.ci" +
        " from boleto b, planilla p, cliente c where b.idcliente=c.id and p.fecha="+fecha+" and b.codPlanilla=p.cod");
        int tuplas=conectar.obtenerCodigoX("select count(b.nro) as cantidad from boleto b,planilla p "
                + "where p.fecha="+fecha+" and b.codPlanilla=p.cod");
        String[][] v=new String[tuplas][6];
        for (int i = 0; i < tuplas; i++) {
            res.next();
            v[i][0]=String.valueOf(res.getInt("nro"));
            v[i][1]=String.valueOf(res.getFloat("precio"));                 
            v[i][2]=String.valueOf(res.getInt("asiento"));
            v[i][3]=String.valueOf(res.getInt("codPlanilla"));
            v[i][4]=String.valueOf(res.getInt("codEmpleado"));
            v[i][5]=String.valueOf(res.getInt("ci"));
        }
        res.close();
        conectar.desconectar();
            Bitacora.bitacora("Lista Boleto");
        return v;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null,"SIN RESULTADOS CON LA FECHA "+ exception.getMessage()); 
            return null;
        }
    }

}