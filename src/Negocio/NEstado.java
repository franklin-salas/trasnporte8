/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DEstado;

/**
 *
 * @author Pablo
 */
public class NEstado {
        private  DEstado conectar;    
 
    // CONTRUCTOR QUE INICIALIZA LA CONEXION DE LA BASE DE DATOS
    public NEstado() throws ClassNotFoundException{
        conectar=new DEstado();
    }
    

    public String insertar(int id,String descripcion,String habilitado){
        conectar.setTodo(id, descripcion, habilitado);
        String resultado=conectar.Insertar();
        return resultado;
    }
    
    public String acutalizar(int id,String descripcion,String habilitado){
        String resultado=conectar.Actualizar(conectar.getDatosActualizar(id, descripcion, habilitado));
        return resultado;
    }
     
    public String[] Consultabuscar(String cod){
        String[] resultado=conectar.ConsultaBuscar(cod);
        return resultado;
    }
    
    public String ObetenerCodigo(){
       int codigo= conectar.ObtenerCodigo()+1;
       return String.valueOf(codigo);
    }

    public String[][] ListaDeEstado() {
        String[][] resultado=conectar.ListaDeLugares();
        return resultado;
    }
}
