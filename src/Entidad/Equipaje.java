package Entidad;


import Datos.*;
import java.sql.CallableStatement;
import java.sql.Types;
import Datos.ConexionDriverSqlServer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:22
 */
public class Equipaje {

    private int cod;
    private String descripcion;
    private float precio;
    private int cantidad;
    private int idNota;

    public Equipaje() {
    }

    public Equipaje(int cod, String descripcion, float precio, int cantidad, int idNota) {
        this.cod = cod;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idNota = idNota;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    
}