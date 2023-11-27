/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author FRANKLIN SALAS
 */
public class GrupoPrivilegio {
   int idGrupo;
   int idPrivilegio;

    public GrupoPrivilegio(int idGrupo, int idPrivilegio) {
        this.idGrupo = idGrupo;
        this.idPrivilegio = idPrivilegio;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(int idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }
   
      
    
}
