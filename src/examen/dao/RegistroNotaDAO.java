/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.dao;

import examen.entities.MiError;
import examen.entities.RegistroNota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class RegistroNotaDAO {
    
    public RegistroNota cargar(int id) {
        
        RegistroNota registro = new RegistroNota();
        try (Connection con = Conexion.conexion()) {
            String sql = "select alumno.nombre,alumno.apellido,alumno.cedula, prueba.nombre,prueba.porcentaje, registro_de_nota.nota from registro_de_nota "
                    + "FULL JOIN alumno ON registro_de_nota.id = alumno.id "
                    + "FULL JOIN prueba ON registro_de_nota.id = prueba.id "
                    + "WHERE registro_de_nota.id_alumno = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            stmt.setInt(1, id);
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las pruebas.");
        }
        return registro;
    }
    
}
