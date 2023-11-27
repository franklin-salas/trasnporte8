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
 * @created 28-may-2016 11:55:25
 */
public class Itinerario {

    private int nro;
    private String fecha;
    private String hora;
    private int codRuta;
    

    public Itinerario() {

    }

    public Itinerario(int nro, String fecha, String hora, int codRuta) {
        this.nro = nro;
        this.fecha = fecha;
        this.hora = hora;
        this.codRuta = codRuta;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCodRuta() {
        return codRuta;
    }

    public void setCodRuta(int codRuta) {
        this.codRuta = codRuta;
    }
  
            
}