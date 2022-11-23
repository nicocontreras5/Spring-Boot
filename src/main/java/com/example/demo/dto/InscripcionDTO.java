package com.example.demo.dto;

public class InscripcionDTO {
    private int idEstudiante;
    private int idCarrera;
    private int inscripcion;
    private int graduacion;

    public InscripcionDTO(int idEstudiante, int idCarrera, int inscripcion, int graduacion) {
        this.idEstudiante = idEstudiante;
        this.idCarrera = idCarrera;
        this.inscripcion = inscripcion;
        this.graduacion = graduacion;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public int getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(int inscripcion) {
        this.inscripcion = inscripcion;
    }

    public int getGraduacion() {
        return graduacion;
    }

    public void setGraduacion(int graduacion) {
        this.graduacion = graduacion;
    }


    @Override
    public String toString() {
        return "InscripcionDTO{" +
                "idEstudiante=" + idEstudiante +
                ", idCarrera=" + idCarrera +
                ", inscripcion=" + inscripcion +
                ", graduacion=" + graduacion +
                '}';
    }
}
