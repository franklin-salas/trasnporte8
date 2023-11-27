package Datos;


import java.sql.ResultSet;
import Datos.ConexionDriverSqlServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
/**
 * @author Pablo
 * @version 1.0
 * @created 28-may-2016 11:55:43
 */
public class DPersona {

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
    
    private ConexionDriverSqlServer conectar;
        
    // CONTRUCTOR QUE INICIALIZA LA CONEXION DE LA BASE DE DATOS
    public DPersona() throws ClassNotFoundException{
        conectar=new ConexionDriverSqlServer();
    }
        
    public String Insertar(int cod, int ci,String nombre,String sexo,String dir,
            int telf,String habilitado,int nroInterno,String categoria,String cargo,
            String tSocio,String tChofer,String tEmpleado,String disponible){
      try {
        conectar.conectar();
        Connection conecta=conectar.getConnection();
        CallableStatement proc = conecta.prepareCall(" EXEC AddPersona ?,?,?,?,?,?,?,?,?,?,?,?,?,? ");  
        proc.setInt("codigo",cod);
        proc.setInt("ci",ci);
        proc.setString("nombre",nombre);
        proc.setString("sexo",sexo);
        proc.setString("dir",dir);
        proc.setInt("telf",telf);
        proc.setString("habilitado",habilitado);
        proc.setString("cargo",cargo);
        proc.setInt("nroInt",nroInterno);
        proc.setString("categoria",categoria);
        proc.setString("disponble",disponible);
        proc.setString("tipoSocio",tSocio);
        proc.setString("tipoChofer",tChofer);
        proc.setString("tipoEmpledo",tEmpleado);
        proc.execute();
        conectar.desconectar();
        Bitacora.bitacora("Inserto Persona");
        return "PERSONA REGISTRADA CORRECTAMENTE";
      }catch (ClassNotFoundException | SQLException  exception) {
        return "DATOS INVALIDOS "+exception.getMessage();        
      }
    }
    
    public String[] ConsultaBuscar(String carnet){
        try {
        ResultSet res = conectar.consulta("select * from persona where ci="+carnet);
        String[] v=new String[14];
        res.next();
        v[0]=String.valueOf( res.getInt("codigo"));
        v[1]=String.valueOf(res.getInt("ci"));                 
        v[2]=res.getString("nombre");
        v[3]=String.valueOf(res.getString("sexo"));
        v[4]=res.getString("dir");
        v[5]=String.valueOf(res.getInt("telf"));
        v[6]=String.valueOf(res.getString("habilitado"));
        v[7]=res.getString("cargo");
        v[8]=String.valueOf(res.getInt("nroInt"));
        v[9]=String.valueOf(res.getString("categoria"));
        v[10]=res.getString("disponble");
        v[11]=String.valueOf(res.getString("tipoSocio"));
        v[12]=String.valueOf(res.getString("tipoChofer"));
        v[13]=String.valueOf(res.getString("tipoEmpledo"));
        res.close(); 
        conectar.desconectar();
     Bitacora.bitacora("Busco Persona");
        return v;
        }catch (Exception  exception) {
            //JOptionPane.showMessageDialog(null,"ERROR EN LA BUSQUEDA CARNET NO ENCONTRADO "+ exception.getMessage());
        }
        return null;
    }
    
    public String[][] ListaDePersonas(String tipo){
        try {
            ResultSet res=null;
            int tuplas=0;
            if (tipo.compareTo("C")==0 || tipo.compareTo("c")==0) {
                res = conectar.consulta("select * from persona where habilitado='SI' and tipoChofer='C' order by nroInt");
                tuplas=conectar.obtenerCodigoX("select count(codigo) as cantidad from persona where habilitado='SI' and tipoChofer='C'");
            }else{
                res = conectar.consulta("select * from persona order by nroInt");
                tuplas=conectar.obtenerCodigoX("select count(codigo) as cantidad from persona");
            }
        
        String[][] v=new String[tuplas][14];
        for (int i = 0; i < tuplas; i++) {
            res.next();
            v[i][0]=String.valueOf( res.getInt("codigo"));
            v[i][1]=String.valueOf(res.getInt("ci"));                 
            v[i][2]=res.getString("nombre");
            v[i][3]=String.valueOf(res.getString("sexo"));
            v[i][4]=res.getString("dir");
            v[i][5]=String.valueOf(res.getInt("telf"));
            v[i][6]=String.valueOf(res.getString("habilitado"));
            v[i][7]=res.getString("cargo");
            v[i][8]=String.valueOf(res.getInt("nroInt"));
            v[i][9]=String.valueOf(res.getString("categoria"));
            v[i][10]=res.getString("disponble");
            v[i][11]=String.valueOf(res.getString("tipoSocio"));
            v[i][12]=String.valueOf(res.getString("tipoChofer"));
            v[i][13]=String.valueOf(res.getString("tipoEmpledo"));
        }
        res.close();
        conectar.desconectar();
        return v;
        }catch (Exception  exception) {
            //JOptionPane.showMessageDialog(null,"ERROR DE DATOS "+ exception.getMessage());
        }
        return null;
    }
    
    // DEVUELVE LA CANTIDAD DE TUPLAS DE LA TABLA
    public int ObtenerCodigoMaximo(){
        String consulta="select max(codigo) as cantidad from persona";
        try {
            int cantidad=conectar.obtenerCodigoX(consulta);
            conectar.desconectar();
            return cantidad;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null,"ERROR EN LA CAPA DE DATOS "+ exception.getMessage());
        }
        return -1;
    }
    
    public int ObtenerNroIntMaximo(){
        String consulta="select max(nroInt) as cantidad from persona";
        try {
            int cantidad=conectar.obtenerCodigoX(consulta);
            conectar.desconectar();
            return cantidad;
        }catch (Exception  exception) {
            JOptionPane.showMessageDialog(null,"ERROR EN LA CAPA DE DATOS "+ exception.getMessage());
        }
        return -1;
    }
    
    public String Actualizar(String[] datosActualizar){
       try {     
        for (int i = 0; i < datosActualizar.length; i++) {
             conectar.actualizar(datosActualizar[i]);
        }
        conectar.desconectar();
      Bitacora.bitacora("Modifico Persona");
        return "DATOS ACTUALIZADOS CORRECTAMENTE";
      }catch (Exception  exception) {
           return "ERROR AL GUARDAR LOS DATOS EDITADOS "+exception.getMessage();        
      } 
    }
        
    // DEVUELVE UN VECTOR DE ACTUALIZACIONES PARA SQL COMO UNA CADENA EN CADA POSICION
    public String[] getDatosActualizar(int cod,int ci,String nombre,String sexo,
            String dir,int telf,int nroInterno,String categoria,
            String cargo,String TSocio,String TChofer,String TVendedor, String disponible, String habilitado)
    {
        String v[]=new String[13];
        //v[13]="update persona set codigo="+cod+ " where CI="+ci;
        v[12]="update persona set ci="+ci+ " where CI="+ci;
        v[2]="update persona set nombre='"+nombre+"' where CI="+ci;
        v[3]="update persona set sexo='"+sexo+ "' where CI="+ci;
        v[4]="update persona set dir='"+dir+ "' where CI="+ci;
        v[5]="update persona set telf="+telf+ " where CI="+ci;
        v[6]="update persona set habilitado='"+habilitado+ "' where CI="+ci;
        v[7]="update persona set cargo='"+cargo+ "' where CI="+ci;
        v[8]="update persona set nroInt="+nroInterno+ " where CI="+ci;
        if (categoria.compareTo("null")==0) {
            v[9]="update persona set categoria="+categoria+ " where CI="+ci;
        }else{
            v[9]="update persona set categoria='"+categoria+ "' where CI="+ci;
        }
        if (disponible.compareTo("null")==0) {
            v[10]="update persona set disponble="+disponible+ " where CI="+ci;
        }else{
            v[10]="update persona set disponble='"+disponible+ "' where CI="+ci;
        }
        if (TSocio.compareTo("null")==0) {
            v[11]="update persona set tipoSocio="+TSocio+ " where CI="+ci;
        }else{
            v[11]="update persona set tipoSocio='"+TSocio+ "' where CI="+ci;
        }
        if (TChofer.compareTo("null")==0) {
            v[0]="update persona set tipoChofer="+TChofer+ " where CI="+ci;
        }else{
            v[0]="update persona set tipoChofer='"+TChofer+ "' where CI="+ci;
        }
        if (TVendedor.compareTo("null")==0) {
            v[1]="update persona set tipoEmpledo="+TVendedor+ " where CI="+ci;
        }else{
            v[1]="update persona set tipoEmpledo='"+TVendedor+ "' where CI="+ci;
        }        
        return v;        
    }
    
    //INSERTA TODOS LOS DATOS DE LA CLASE DPersona
    public void setTodo(int cod, int ci,String nombre,String sexo,String dir,
            int telf,String habilitado,int nroInterno,String categoria,String cargo,
            String tSocio,String tChofer,String tVendedor,String disponible)
    {
         this.codigo=cod;
         this.ci=ci;
         this.nombre=nombre;
         this.sexo=sexo;
         this.dir=dir;
         this.telf=telf;
         this.habilitado=habilitado;
         this.nroInt=nroInterno; 
         this.categoria=categoria;
         this.cargo=cargo;
         this.tSocio=tSocio;
         this.tChofer=tChofer;
         this.tEmpleado=tVendedor;
         this.disponible=disponible;
    }
    
    public String getInsercion(){
        String resultado="";
        if (this.tSocio.compareTo("null")==0 && this.tChofer.compareTo("null")==0) {
            resultado="insert into Cliente values("+this.codigo+","+this.ci+",'"+this.nombre+"',"
                +"'"+this.sexo+"'"+",'"+this.dir+"',"+telf+",'"+this.habilitado+"','"+this.cargo
                +"',"+this.nroInt+",'"+this.categoria+"',"+this.disponible+","+this.tSocio+","
                +this.tChofer+",'"+this.tEmpleado+"')";
        }
        
        if (this.tSocio.compareTo("null")==0 && this.tEmpleado.compareTo("null")==0) {
            resultado="insert into Cliente values("+this.codigo+","+this.ci+",'"+this.nombre+"',"
                +"'"+this.sexo+"'"+",'"+this.dir+"',"+telf+",'"+this.habilitado+"',"+this.cargo
                +","+this.nroInt+",'"+this.categoria+"','"+this.disponible+"',"+this.tSocio+","
                +"'"+this.tChofer+"',"+this.tEmpleado+")";
        }else{
            if (this.tSocio.compareTo("S")==0 && this.tChofer.compareTo("C")==0) {
                if (cargo.compareTo("null")==0) {
                    return "insert into Cliente values("+this.codigo+","+this.ci+",'"+this.nombre+"',"
                +"'"+this.sexo+"'"+",'"+this.dir+"',"+telf+",'"+this.habilitado+"',"+this.cargo
                +","+this.nroInt+",'"+this.categoria+"','"+this.disponible+"','"+this.tSocio+"',"
                +"'"+this.tChofer+"',"+this.tEmpleado+")";
                }
                resultado="insert into Cliente values("+this.codigo+","+this.ci+",'"+this.nombre+"',"
                +"'"+this.sexo+"'"+",'"+this.dir+"',"+telf+",'"+this.habilitado+"','"+this.cargo
                +"',"+this.nroInt+",'"+this.categoria+"','"+this.disponible+"','"+this.tSocio+"',"
                +"'"+this.tChofer+"',"+this.tEmpleado+")";
            }else{
                if (this.tSocio.compareTo("S")==0) {
                    if (cargo.compareTo("null")==0) {
                        return "insert into Cliente values("+this.codigo+","+this.ci+",'"+this.nombre+"',"
                        +"'"+this.sexo+"'"+",'"+this.dir+"',"+telf+",'"+this.habilitado+"',"+this.cargo
                        +","+this.nroInt+",'"+this.categoria+"','"+this.disponible+"','"+this.tSocio+"',"
                        +this.tChofer+","+this.tEmpleado+")";
                    }
                    return "insert into Cliente values("+this.codigo+","+this.ci+",'"+this.nombre+"',"
                    +"'"+this.sexo+"'"+",'"+this.dir+"',"+telf+",'"+this.habilitado+"','"+this.cargo
                    +"',"+this.nroInt+","+this.categoria+",'"+this.disponible+"','"+this.tSocio+"',"
                    +this.tChofer+","+this.tEmpleado+")";
                }
            
            }
        }
        return resultado;
    }
}