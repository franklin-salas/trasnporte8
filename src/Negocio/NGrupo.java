/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DGrupo;
import Entidad.Grupo;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author FRANKLIN SALAS
 */
public class NGrupo {
    
    public static DefaultComboBoxModel obtener(){
        DGrupo g = new DGrupo();
    List<Grupo> lis=    g.obtenerGrupos();
    if(lis==null)
    return  null;
    DefaultComboBoxModel m = new DefaultComboBoxModel();
    
        for (Grupo li : lis) {
           m.addElement(li.getNombre());            
        }
    
    return  m;
    }
    
}
