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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class AlumnoDAO {

    /**
     * inserta al alumno que recibe por parametro
     * @param a
     * @return true = si se agregro y false = si hubo un error
     */
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
    /**
     * Carga todos los alumnos de la base de datos
     * @return la lista de los alumnos
     */
    public ArrayList<Alumno> cargar() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from alumno";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                alumnos.add(cargarAlumno(rs));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las pruebas.");
        }
        return alumnos;
    }
    
    /**
     * cargar el alumno que recibe de la base de datos al objeto
     * @param rs
     * @return un objeto Alumno
     * @throws SQLException 
     */
    public Alumno cargarAlumno(ResultSet rs) throws SQLException{
        Alumno a = new Alumno();
        
        a.setId(rs.getInt("id"));
        a.setNombre(rs.getString("nombre"));
        a.setApellido(rs.getString("apellido"));
        a.setCedula(rs.getString("cedula"));
        return a;
    }
}
