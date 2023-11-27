package Entidad;

import Datos.*;
import Datos.ConexionDriverSqlServer;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:42
 */
public class Encomienda {

	private int cod;
	private String descripcion;
	private float precio;
	private int cantidad;
        private int idGuia;        

    public Encomienda() {
    }

        
    public Encomienda(int cod, String descripcion, float precio, int cantidad, int idGuia) {
        this.cod = cod;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idGuia = idGuia;
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

    public int getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(int idGuia) {
        this.idGuia = idGuia;
    }
  
   

}