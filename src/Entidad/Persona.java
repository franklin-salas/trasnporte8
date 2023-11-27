package Entidad;


import Datos.*;
import java.sql.ResultSet;
import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:43
 */
public class Persona {

    private int codigo;
    private int ci;
    private String nombre;
    private String sexo;
    private String dir;
    private int telf;
    private String habilitado;
    private int nroInt;
    private String categoria;
    private String cargo;
    private String disponible;
    private String tSocio;
    private String tChofer;
    private String tEmpleado;

        
    // CONTRUCTOR QUE INICIALIZA LA CONEXION DE LA BASE DE DATOS
    public Persona() {
    
    }

    public Persona(int codigo, int ci, String nombre, String sexo, String dir, int telf, String habilitado, int nroInt, String categoria, String cargo, String disponible, String tSocio, String tChofer, String tEmpleado) {
        this.codigo = codigo;
        this.ci = ci;
        this.nombre = nombre;
        this.sexo = sexo;
        this.dir = dir;
        this.telf = telf;
        this.habilitado = habilitado;
        this.nroInt = nroInt;
        this.categoria = categoria;
        this.cargo = cargo;
        this.disponible = disponible;
        this.tSocio = tSocio;
        this.tChofer = tChofer;
        this.tEmpleado = tEmpleado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

    public int getNroInt() {
        return nroInt;
    }

    public void setNroInt(int nroInt) {
        this.nroInt = nroInt;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String gettSocio() {
        return tSocio;
    }

    public void settSocio(String tSocio) {
        this.tSocio = tSocio;
    }

    public String gettChofer() {
        return tChofer;
    }

    public void settChofer(String tChofer) {
        this.tChofer = tChofer;
    }

    public String gettEmpleado() {
        return tEmpleado;
    }

    public void settEmpleado(String tEmpleado) {
        this.tEmpleado = tEmpleado;
    }
    
 

}