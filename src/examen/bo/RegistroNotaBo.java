/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.bo;

import examen.dao.RegistroNotaDAO;
import examen.entities.MiError;
import examen.entities.RegistroNota;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class RegistroNotaBo {
    /**
     * verifica que el objeto este correcto y llama al metodo de insertar
     * @param r
     * @return true = si se pudo agregar y false = si el objecto esta incompleto
     */
    public boolean registrar(RegistroNota r){
        if(r.getNota()<0){
            throw new MiError("Nota requerida");
        }
        RegistroNotaDAO rdao = new RegistroNotaDAO();
        return rdao.insertar(r);
    }
    
    public ArrayList<RegistroNota> cargarRegistro(int id){
        RegistroNotaDAO rdao = new RegistroNotaDAO();
        return rdao.cargar(id);
    }
}
