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

    /**
     * Cargar los registros de Notas
     *
     * @param id
     * @return el objeto registro de nota
     */
    public ArrayList<RegistroNota> cargar(int id) {
        ArrayList<RegistroNota> registro = new ArrayList<>();
        int cantidad = 0;
        int cantidad2 = 0;
        try (Connection con = Conexion.conexion()) {

            String sql = "select * from prueba";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cantidad++;
            }
            String sql2 = "select * from registro_de_nota where id_alumno = ?";
            PreparedStatement stmt2 = con.prepareStatement(sql2);
            stmt2.setInt(1, id);
            ResultSet rs2 = stmt2.executeQuery();
            while (rs2.next()) {
                cantidad2++;
            }
            if (cantidad == cantidad2) {
                String sql3 = "select * from registro_de_nota where id_alumno = ?";
                PreparedStatement stmt3 = con.prepareStatement(sql3);
                stmt3.setInt(1, id);
                ResultSet rs3 = stmt3.executeQuery();
                while (rs3.next()) {
                    registro.add(cargarRegistro(rs3));
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las pruebas.");
        }
        return registro;
    }

    /**
     * Inserta un registro de nota que recibe por parametro
     *
     * @param r
     * @return true = si se realizo y false = sino
     */
    public boolean insertar(RegistroNota r) {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into registro_de_nota(id_alumno,id_prueba,nota) values(?,?,?)";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setInt(1, r.getId_alumno());
            stmt.setInt(2, r.getId_prueba());
            stmt.setFloat(3, r.getNota());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al insertar registro.");
        }
    }

    public RegistroNota cargarRegistro(ResultSet rs) throws SQLException {
        RegistroNota r = new RegistroNota();
        r.setId_alumno(rs.getInt("id_alumno"));
        r.setId_prueba(rs.getInt("id_prueba"));
        r.setNota(rs.getFloat("nota"));
        return r;
    }

}
