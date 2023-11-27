package Entidad;

import Datos.*;



/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:56:29
 */
public class Estado {

 private int id ;
 private String descripcion ;
 private boolean habilitado ;
	public Estado(){

	}

    public Estado(int id, String descripcion, boolean habilitado) {
        this.id = id;
        this.descripcion = descripcion;
        this.habilitado = habilitado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

	
}