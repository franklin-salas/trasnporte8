package Entidad;


import Datos.*;
import java.sql.CallableStatement;
import java.sql.Types;
import Datos.ConexionDriverSqlServer;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:22
 */
public class Boleto {

	private int Nro;
	private float precio;
	private int asiento;
	private int codplanilla;
	private int codPersona;
	private int IdCliente;

       
	
        public Boleto() {
          
	}

    public Boleto(int Nro, float precio, int asiento, int codplanilla, int codPersona, int IdCliente) {
        this.Nro = Nro;
        this.precio = precio;
        this.asiento = asiento;
        this.codplanilla = codplanilla;
        this.codPersona = codPersona;
        this.IdCliente = IdCliente;
    }

    public int getNro() {
        return Nro;
    }

    public float getPrecio() {
        return precio;
    }

    public int getAsiento() {
        return asiento;
    }

    public int getCodplanilla() {
        return codplanilla;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setNro(int Nro) {
        this.Nro = Nro;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public void setCodplanilla(int codplanilla) {
        this.codplanilla = codplanilla;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }
    
 

}