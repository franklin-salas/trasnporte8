/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

import Datos.*;
import Datos.ConexionDriverSqlServer;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo
 */
public class HojaDeLlegada {

	private int id;
	private String hora;
	private String fecha;
        private int codPlanilla;
        
  
    public HojaDeLlegada(){
 
    }

    public HojaDeLlegada(int id, String hora, String fecha, int codPlanilla) {
        this.id = id;
        this.hora = hora;
        this.fecha = fecha;
        this.codPlanilla = codPlanilla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCodPlanilla() {
        return codPlanilla;
    }

    public void setCodPlanilla(int codPlanilla) {
        this.codPlanilla = codPlanilla;
    }

    
}
