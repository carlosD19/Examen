/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.bo;

import examen.dao.AlumnoDAO;
import examen.entities.Alumno;
import examen.entities.MiError;

/**
 *
 * @author pc
 */
public class AlumnoBo {
    
    public boolean registrar(Alumno a){
        
        if(a.getNombre().isEmpty()){
            throw new MiError("Nombre requerido.");
        }
        if(a.getApellido().isEmpty()){
            throw new MiError("Apellido requerido.");
        }
        if(a.getCedula().isEmpty()){
            throw new MiError("Cedula requerido.");
        }
        
        AlumnoDAO adao = new AlumnoDAO();
        return adao.insertar(a);
    }
}
