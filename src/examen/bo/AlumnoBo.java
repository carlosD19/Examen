/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.bo;

import examen.dao.AlumnoDAO;
import examen.entities.Alumno;
import examen.entities.MiError;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class AlumnoBo {
    /**
     * Metodo para verificar si el alumno tiene todos sus atributos
     * @param a
     * @return true = si el el alumno se registro con exito y false = si el alumno no esta completo
     */
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
    /**
     * llama a metodo de cargar todos los alumnos de la base de datos
     * @return la lista de los alumnos
     */
    public ArrayList<Alumno> cargarTodo(){
        AlumnoDAO adao = new AlumnoDAO();
        return adao.cargar();
    }
}
