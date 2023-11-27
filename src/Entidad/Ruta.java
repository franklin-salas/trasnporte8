package Entidad;

import Datos.*;
import java.sql.ResultSet;
import Datos.ConexionDriverSqlServer;
import javax.swing.JOptionPane;

/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:56:05
 */
public class Ruta {

    private int cod;
    private float costo;    
    private String tiempoDeViaje;
    private int codOrigen;
    private int codDestino;
    
    
   
    public Ruta(){
       
    }

    public Ruta(int cod, float costo, String tiempoDeViaje, int codOrigen, int codDestino) {
        this.cod = cod;
        this.costo = costo;
        this.tiempoDeViaje = tiempoDeViaje;
        this.codOrigen = codOrigen;
        this.codDestino = codDestino;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getTiempoDeViaje() {
        return tiempoDeViaje;
    }

    public void setTiempoDeViaje(String tiempoDeViaje) {
        this.tiempoDeViaje = tiempoDeViaje;
    }

    public int getCodOrigen() {
        return codOrigen;
    }

    public void setCodOrigen(int codOrigen) {
        this.codOrigen = codOrigen;
    }

    public int getCodDestino() {
        return codDestino;
    }

    public void setCodDestino(int codDestino) {
        this.codDestino = codDestino;
    }
    
  
    
   
}