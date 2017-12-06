/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.bo;

import examen.dao.PruebaDAO;
import examen.entities.Prueba;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class PruebaBo {
    
    public ArrayList<Prueba> cargarTodo(){
        PruebaDAO pdao = new PruebaDAO();
        return pdao.cargar();
    }
}
