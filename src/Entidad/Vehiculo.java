package Entidad;

import Datos.*;
import Datos.ConexionDriverSqlServer;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:56:23
 */
public class Vehiculo {

	private int id;
	private String Placa;
	private int Capacidad;
	private String Tipo;
	private int Modelo;
	private int codPersona;
	private int idEstado;
        private int codSoat;
	private int codCredinform;
	private int anio;

      
	public Vehiculo() {
      
	}

    public Vehiculo(int id, String Placa, int Capacidad, String Tipo, int Modelo, int codPersona, int idEstado, int codSoat, int codCredinform, int anio) {
        this.id = id;
        this.Placa = Placa;
        this.Capacidad = Capacidad;
        this.Tipo = Tipo;
        this.Modelo = Modelo;
        this.codPersona = codPersona;
        this.idEstado = idEstado;
        this.codSoat = codSoat;
        this.codCredinform = codCredinform;
        this.anio = anio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getModelo() {
        return Modelo;
    }

    public void setModelo(int Modelo) {
        this.Modelo = Modelo;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getCodSoat() {
        return codSoat;
    }

    public void setCodSoat(int codSoat) {
        this.codSoat = codSoat;
    }

    public int getCodCredinform() {
        return codCredinform;
    }

    public void setCodCredinform(int codCredinform) {
        this.codCredinform = codCredinform;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
        
  
}