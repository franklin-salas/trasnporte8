package Entidad;

import Datos.*;
import Datos.ConexionDriverSqlServer;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:55
 */
public class Guia {

	private int Codigo;
	private String Fecha;
	private float Costo;
	private String EstadoDeCobro;
	private int codPlanilla;
	private int codEmpleado;
	private int idEnvia;
	private int idRecibe;
   
	public Guia(){

	}

    public Guia(int Codigo, String Fecha, float Costo, String EstadoDeCobro, int codPlanilla, int codEmpleado, int idEnvia, int idRecibe) {
        this.Codigo = Codigo;
        this.Fecha = Fecha;
        this.Costo = Costo;
        this.EstadoDeCobro = EstadoDeCobro;
        this.codPlanilla = codPlanilla;
        this.codEmpleado = codEmpleado;
        this.idEnvia = idEnvia;
        this.idRecibe = idRecibe;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public float getCosto() {
        return Costo;
    }

    public void setCosto(float Costo) {
        this.Costo = Costo;
    }

    public String getEstadoDeCobro() {
        return EstadoDeCobro;
    }

    public void setEstadoDeCobro(String EstadoDeCobro) {
        this.EstadoDeCobro = EstadoDeCobro;
    }

    public int getCodPlanilla() {
        return codPlanilla;
    }

    public void setCodPlanilla(int codPlanilla) {
        this.codPlanilla = codPlanilla;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public int getIdEnvia() {
        return idEnvia;
    }

    public void setIdEnvia(int idEnvia) {
        this.idEnvia = idEnvia;
    }

    public int getIdRecibe() {
        return idRecibe;
    }

    public void setIdRecibe(int idRecibe) {
        this.idRecibe = idRecibe;
    }
     
    
}