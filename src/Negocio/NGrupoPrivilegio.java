/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DGrupoPrivilegio;
import Entidad.GrupoPrivilegio;
import java.util.List;

/**
 *
 * @author FRANKLIN SALAS
 */
public class NGrupoPrivilegio {
    
    public static List<GrupoPrivilegio> obtener(String grupo){
        DGrupoPrivilegio n = new DGrupoPrivilegio();
        
    return n.obtener(grupo);
    }
    
    public static List<GrupoPrivilegio> obtener(int idgrupo){
        DGrupoPrivilegio n = new DGrupoPrivilegio();
        
    return n.obtener(idgrupo);
    }
    
    public static void insetar(List<GrupoPrivilegio> lis){

    DGrupoPrivilegio n = new DGrupoPrivilegio();
    n.insertar(lis);

}

}

