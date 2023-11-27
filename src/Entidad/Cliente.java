package Entidad;


import Datos.*;
import java.sql.ResultSet;
import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:54:35
 */
public class Cliente {

	private int ID;
	private int CI;
        private String Nombre;
	private char Sexo;

    public Cliente() {
    }

    public Cliente(int ID, int CI, String Nombre, char Sexo) {
        this.ID = ID;
        this.CI = CI;
        this.Nombre = Nombre;
        this.Sexo = Sexo;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCI(int CI) {
        this.CI = CI;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }

    public int getID() {
        return ID;
    }

    public int getCI() {
        return CI;
    }

    public String getNombre() {
        return Nombre;
    }

    public char getSexo() {
        return Sexo;
    }
	
        
   

}