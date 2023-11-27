package Entidad;

import Datos.*;
import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:56:12
 */
public class Seguro {

	private int cod;
	private String tipoSeguro;
      
	public Seguro() {
         
	}

    public Seguro(int cod, String tipoSeguro) {
        this.cod = cod;
        this.tipoSeguro = tipoSeguro;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }
        


}