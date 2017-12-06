/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.entities;

/**
 *
 * @author pc
 */
public class RegistroNota {
    private int id;
    private int id_alumno;
    private int id_prueba;
    private float nota;

    public RegistroNota() {
    }

    
    public RegistroNota(int id_alumno, int id_prueba, float nota) {
        this.id_alumno = id_alumno;
        this.id_prueba = id_prueba;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_prueba() {
        return id_prueba;
    }

    public void setId_prueba(int id_prueba) {
        this.id_prueba = id_prueba;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
    
}
