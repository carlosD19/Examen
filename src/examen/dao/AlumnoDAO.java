/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.dao;

import examen.entities.Alumno;
import examen.entities.MiError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class AlumnoDAO {

    public boolean insertar(Alumno a) {
          try (Connection con = Conexion.conexion()) {
            String sql = "insert into alumno(nombre,apellido,cedula) values(?,?,?)";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, a.getNombre());
            stmt.setString(2, a.getApellido());
            stmt.setString(3, a.getCedula());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new MiError("El alumno ya existe.");
        }
          catch (Exception ex) {
            throw new MiError("Problemas al insertar alumno.");
        }
    }
    
}
