/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

////import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**import
 *
 * @author FRANKLIN SALAS
 */
public class ConexionDriverSqlServer {
      String servidor="DESKTOP-K1Q247L\\SQLEXPRESS";//Nombre de la instancia del servidor en sql
     String puerto="1433";//puerto q utiliza sql server para comunicarse
     String user="admin";//usuario creado por la base de datos
     String password="admin";//contrasenna de usuario creado en la base de datos
     String baseDatos="transporte2";//nombre de la base de datos
     String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//
 /*   static String servidor="pablo-pc";//Nombre de la instancia del servidor en sql
    static String puerto="1433";//puerto q utiliza sql server para comunicarse
    static String user="sa";//usuario creado por la base de datos
    static String password="1234567890";//contrasenna de usuario creado en la base de datos
    static String baseDatos="transporte2";//nombre de la base de datos
     String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//*/
      Connection con=null;
//jdbc:sqlserver://pablo-pc\transporte:1433;databaseName=transporte2 [sa en Sistema por omisión]
    public ConexionDriverSqlServer() throws ClassNotFoundException {
        
    }
    
    public String conectar() throws ClassNotFoundException{
        try {
            Class.forName(driver);
            String url="jdbc:sqlserver://"+servidor+"\\"+"transporte" +":"+puerto+";"
        +"databaseName="+baseDatos+";user="+user+";password="+password+";" + "encrypt=false;" + "trustServerCertificate=false;";
            con =DriverManager.getConnection(url);
        //JOptionPane.showMessageDialog(null, "coneion correcta a sql server 2008","conexion sql",JOptionPane.INFORMATION_MESSAGE);
            return "Conexion Correcta";
        } catch (SQLException e) {
            return ("SQL Exception: "+ e.toString());
        }
    }
    
    public Connection getConnection() {
        return con;
    }
    
    public void desconectar()throws ClassNotFoundException{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionDriverSqlServer.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public boolean insertar(String consulta) throws ClassNotFoundException {
        Statement declara;
        try {
            conectar();
            declara = con.createStatement();
            boolean respuesta = declara.execute(consulta);
            //desconectar();
            return respuesta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
        
    public ResultSet consulta(String consulta) throws ClassNotFoundException {
        Statement declara;
        try {
            conectar();
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            //desconectar();
            return respuesta;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public boolean actualizar(String consulta) throws ClassNotFoundException {
        Statement declara;
        try {
            conectar();
            declara = con.createStatement();
            boolean respuesta = declara.execute(consulta);
            desconectar();
            return respuesta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public int obtenerCodigoX(String consulta) throws ClassNotFoundException {
        Statement declara;
        try {
            conectar();
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            respuesta.next();
            int cantidad=respuesta.getInt("cantidad");
           desconectar();
            return cantidad;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
    
}
