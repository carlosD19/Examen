/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.dao;

import examen.entities.MiError;
import examen.entities.Prueba;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class PruebaDAO {

    /**
     * Cargar todas las pruebas que existan en la base de datos
     * @return la lista de pruebas
     */
    public ArrayList<Prueba> cargar(){

       ArrayList<Prueba> pruebas = new ArrayList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from prueba";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pruebas.add(cargarPrueba(rs));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las pruebas.");
        }
        return pruebas;
    }
    /**
     * Carga la prueba que recibe por parametro al objeto
     * @param rs
     * @return el objeto Prueba
     * @throws SQLException 
     */
    public Prueba cargarPrueba(ResultSet rs) throws SQLException{
        Prueba p = new Prueba();
        
        p.setId(rs.getInt("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPorcentaje(rs.getFloat("porcentaje"));
        
        return p;
    }
    
}
