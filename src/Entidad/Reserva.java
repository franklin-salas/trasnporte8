package Entidad;

import Datos.*;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:58
 */
public class Reserva {

	private int ID;
	private String Fecha;
	private String Hora;
	
	public Reserva() {
    
	}

    public Reserva(int ID, String Fecha, String Hora) {
        this.ID = ID;
        this.Fecha = Fecha;
        this.Hora = Hora;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

   
        
}