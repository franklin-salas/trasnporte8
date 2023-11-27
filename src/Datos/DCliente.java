package Datos;


import java.sql.ResultSet;
import Datos.ConexionDriverSqlServer;
import Entidad.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:35
 */
public class DCliente {

	private int ID;
	private int CI;
        private String Nombre;
	private String Sexo;
	
        private ConexionDriverSqlServer conectar;
        
    // CONTRUCTOR QUE INICIALIZA LA CONEXION DE LA BASE DE DATOS
    public DCliente() throws ClassNotFoundException{
        conectar=new ConexionDriverSqlServer();
    }
        
    public String Insertar(int cod, int CI,String Nombre,String Sexo){
        
       try {
            conectar.conectar();
            Connection conecta=conectar.getConnection();
            CallableStatement proc = conecta.prepareCall("EXEC AddCliente ?,?,?,?");
            proc.setInt("id", cod);//Tipo entero
            proc.setString("nombre", Nombre);//Tipo String
            proc.setString("sexo",Sexo);//Tipo String
            proc.setInt("ci",CI);//Tipo String
            proc.execute();
            conectar.desconectar();
                Bitacora.bitacora("Inserto Cliente");
            return "CLIENTE REGISTRADO CORRECTAMENTE";
      }catch (Exception  exception) {
        return "DATOS INVALIDOS "+exception.getMessage();        
      }
    }
    
    public String[] ConsultaBuscar(String carnet){
        try {   
        ResultSet res = conectar.consulta("select * from cliente where ci="+carnet);
        String[] v=new String[4];
        res.next();
        v[0]=String.valueOf( res.getInt("id"));
        v[1]=String.valueOf(res.getInt("ci"));                 
        v[2]=res.getString("nombre");
        v[3]=String.valueOf(res.getString("sexo"));
        res.close();
        conectar.desconectar();
            Bitacora.bitacora("Busco Cliente");
        return v;
        }catch (Exception  exception) {
            exception.getMessage();
        }
        return null;
    }
    
    public String[][] ListaDeClientes(){
        try {   
        ResultSet res = conectar.consulta("select * from cliente");
        int tuplas=conectar.obtenerCodigoX("select count(id) as cantidad from cliente");
        String[][] v=new String[tuplas][4];
        for (int i = 0; i < v.length; i++) {
                res.next();
                 v[i][0]=String.valueOf(res.getInt("id"));
                 v[i][1]=res.getString("nombre");
                 v[i][2]=res.getString("sexo");
                 v[i][3]=String.valueOf(res.getInt("ci"));
        }                         
        res.close();
        conectar.desconectar();
        return v;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION "+exception.getMessage());
        }
        return null;
    }
    
    // DEVUELVE LA CANTIDAD DE TUPLAS DE LA TABLA
    public int ObtenerCodigoMaximo(){
        String consulta="select max(id) as cantidad from cliente";
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
        conectar.desconectar();
            Bitacora.bitacora("Modifico Cliente");
        return "DATOS ACTUALIZADOS CORRECTAMENTE";
      }catch (Exception  exception) {
           return exception.getMessage();        
      } 
    }
    
    // DEVUELVE UN VECTOR DE ACTUALIZACIONES PARA SQL COMO UNA CADENA EN CADA POSICION
    public String[] getDatosActualizar(int ID,int CI,String Nombre,String Sexo){
        String v[]=new String[3];
        v[0]="update cliente set nombre='"+Nombre+"' where CI="+CI;
        v[1]="update cliente set sexo='"+Sexo+ "' where CI="+CI;
        v[2]="update cliente set ci="+CI+ " where ID="+ID;
        return v;        
    }
        
    //INSERTA TODOS LOS DATOS DE LA CLASE CLIENTE Y EQUIPJE
    public void setTodo(int ID,int CI,String Nombre,String Sexo){
         this.ID=ID;
         this.CI=CI;
         this.Nombre=Nombre;
         this.Sexo=Sexo;
    }
    
    //DEVUELVE UNA INSERCION EN SQL DE TIPO STRING  DE LA CLASE CLIENTE
    public String getInsercion(){
        return "insert into Cliente values("+this.ID+",'"+this.Nombre+"','"+this.Sexo+"',"+this.CI+");";
    }
 public Cliente   buscarPorID (int idCliente){
     
    Cliente eq=null;
           try {
               
               
              
               conectar.conectar();
               
                   PreparedStatement r = conectar.getConnection().prepareStatement("{call  BuscarPorIDliente(?)}");
                   r.setInt(1,idCliente);
                   
                   ResultSet s = r.executeQuery();
                   if (s.next()){
                       eq= new Cliente(s.getInt("id"), s.getInt("ci"),s.getString("nombre"), s.getString("sexo").charAt(0));
                   }
                   s.close();
                   r.close();
                   conectar.desconectar();
                   
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,"ERROR PA "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
                   return null;
               }
               
          
            catch (ClassNotFoundException ex) {
                Logger.getLogger(DCliente.class.getName()).log(Level.SEVERE, null, ex);
           }
                
               return eq;
    }  
	
     public Cliente   buscar (int ciCliente){
     Cliente eq=null;
    
           try {
        
             conectar.conectar();
       
               PreparedStatement r = conectar.getConnection().prepareStatement("{call  BuscarPorCIliente(?)}");
           r.setInt(1,ciCliente);
          
             ResultSet s = r.executeQuery();
             if (s.next()){             
       eq= new Cliente(s.getInt("id"), s.getInt("ci"),s.getString("nombre"), s.getString("sexo").charAt(0));
             }
      s.close();
     r.close();
      conectar.desconectar();
         
           } catch (ClassNotFoundException ex) {
             Logger.getLogger(DCliente.class.getName()).log(Level.SEVERE, null, ex);
         }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"ERROR PA "+ex.toString(), "Mensaje",JOptionPane.ERROR_MESSAGE);
               return null;
           }
      
          
   return eq;
         
    }  
}