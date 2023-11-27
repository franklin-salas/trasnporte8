package Entidad;


import Datos.*;
import java.sql.ResultSet;
import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:35
 */
public class Lugar {

    private int cod;
    private String nombre;

    public Lugar() {

    }

    public Lugar(int cod, String nombre) {
        this.cod = cod;
        this.nombre = nombre;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
   

}