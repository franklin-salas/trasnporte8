package Entidad;

import Datos.*;
import Datos.ConexionDriverSqlServer;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:51
 */
public class Planilla {

	private int cod;
	private float costoPlanilla;
	private String fecha;
	private String hora;
	private float totalPasaje;
      	private int codChofer;
	private int idVehiculo;
	private int nroItinerario;


    public Planilla() {

    }

    public Planilla(int cod, float costoPlanilla, String fecha, String hora, int codChofer, int idVehiculo) {
        this.cod = cod;
        this.costoPlanilla = costoPlanilla;
        this.fecha = fecha;
        this.hora = hora;
        this.codChofer = codChofer;
        this.idVehiculo = idVehiculo;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public float getCostoPlanilla() {
        return costoPlanilla;
    }

    public void setCostoPlanilla(float costoPlanilla) {
        this.costoPlanilla = costoPlanilla;
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

    public float getTotalPasaje() {
        return totalPasaje;
    }

    public void setTotalPasaje(float totalPasaje) {
        this.totalPasaje = totalPasaje;
    }

    public int getCodChofer() {
        return codChofer;
    }

    public void setCodChofer(int codChofer) {
        this.codChofer = codChofer;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getNroItinerario() {
        return nroItinerario;
    }

    public void setNroItinerario(int nroItinerario) {
        this.nroItinerario = nroItinerario;
    }
        
  
        
}