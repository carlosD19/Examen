/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.bo;

import examen.dao.RegistroNotaDAO;
import examen.entities.RegistroNota;

/**
 *
 * @author pc
 */
public class RegistroNotaBo {
    
    
    
    public RegistroNota cargarRegistro(int id){
        RegistroNotaDAO rdao = new RegistroNotaDAO();
        return rdao.cargar(id);
    }
}
